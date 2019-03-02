import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser
{
    public static void main(String[] args)
    {
        printDateParts("1397/12/11");
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        while (scanner.hasNextLine() &&
                !(inputLine = scanner.nextLine()).equalsIgnoreCase("end")) //Getting input till 'end' is not input
            printDateParts(inputLine);
    }

    private static Pattern datePattern = Pattern.compile("^(\\d{2,4})/(\\d{1,2})/(\\d{1,2})$");
    private static void printDateParts(String strDate)
    {
        Matcher matcher = datePattern.matcher(strDate);
        if(!matcher.find())
        {
            System.out.println("Invalid date format");
            return;
        }

        System.out.println("year = " + matcher.group(1));
        System.out.println("month = " + matcher.group(2));
        System.out.println("day = " + matcher.group(3));
    }

}
