import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersAdder
{
    public static void main(String[] args)
    {
        System.err.println(sumUpNumbersInText("hello 123 321"));
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        while (!(inputLine = scanner.nextLine()).equalsIgnoreCase("end")) //Getting input till 'end' is not input
            System.out.println(sumUpNumbersInText(inputLine));
    }

    private static int sumUpNumbersInText(String str)
    {
        int sum = 0;
        //Step 1: Compiling your regex into java regex machine: Pattern
        Pattern pattern = Pattern.compile("\\b[-+]?\\d+\\b");
        //Step 2: Matching your pattern with a text. Matcher will check your text against the pattern.
        Matcher matcher = pattern.matcher(str);
        //Step 3: Calling `find`. Matcher starts searching text until it finds a text matching your pattern.
        while (matcher.find())
        {
            //Step 4: Retrieving the groups.
            String strNumber = matcher.group(0); //Group 0 is the whole text matched with the pattern.
            sum += Integer.parseInt(strNumber);
        }

        return sum;
    }
}
