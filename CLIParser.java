import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLIParser
{
    /*
    A parser can be used to interpret a line in a CLI with this format:
    command -param1 value1 -param2 "value in double quotes"
    Example:
    delete -path "my file.txt" -forced true
     */

    /***
     * Regex to for text in double quotes: "[^"\\]*(?:\\.[^"\\]*)*"
     */
    private static final String STRING_PATTERN = "\"[^\"\\\\]*(?:\\\\.[^\"\\\\]*)*\"";

    public static void main(String[] args)
    {
        parseAndPrintCommand("delete -path \"my file.txt\" -forced true");
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        while (scanner.hasNextLine() &&
                !(inputLine = scanner.nextLine()).equalsIgnoreCase("end")) //Getting input till 'end' is not input
            parseAndPrintCommand(inputLine);
    }

    private static void parseAndPrintCommand(String str)
    {
        Pattern commandPattern = Pattern.compile("^\\s*(?<command>\\w+)");
        Matcher m = commandPattern.matcher(str);
        if (!m.find())
        {
            System.out.println("Invalid input");
            return;
        }

        System.out.println("command = " + m.group("command"));

        Pattern paramsPattern = Pattern.compile("-(?<param>\\w+)\\s+(?<value>" + STRING_PATTERN + "|\\w+)");
        m.usePattern(paramsPattern);
        System.out.println("Parameters:");
        while (m.find())
            System.out.println(m.group("param") + " = " + m.group("value"));
    }
}
