import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DurationCalculatorRegex
{
    private static final int MINUTES_IN_HOUR = 60;
    private static final int HOURS_IN_DAY = 24;

    //Regex implementation of duration calculator
    //12:20 -> 13:40    =>  1:20
    public static void main(String[] args)
    {
        processString("12:20 -> 13:50");
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        while (scanner.hasNextLine() &&
                !(inputLine = scanner.nextLine()).equalsIgnoreCase("end")) //Getting input till 'end' is not input
            processString(inputLine);

    }

    private static Pattern durationPattern = Pattern.compile("(\\d{1,2}):(\\d{1,2})\\s*->\\s*(\\d{1,2}):(\\d{1,2})");

    /***
     * Searches the string to find a duration in it then prints it otherwise, 'Invalid input' will be printed.
     * @param str The string to be processed
     */
    private static void processString(String str)
    {
        Matcher m = durationPattern.matcher(str);
        if (!m.find())
        {
            System.out.println("Invalid input");
            return;
        }

        int start = Integer.parseInt(m.group(1)) * MINUTES_IN_HOUR + Integer.parseInt(m.group(2));
        int end = Integer.parseInt(m.group(3)) * MINUTES_IN_HOUR + Integer.parseInt(m.group(4));
        int totalMinutes = calcDuration(start, end);
        System.err.println("Total minutes: " + totalMinutes);
        System.out.printf("%d:%d\n", totalMinutes / MINUTES_IN_HOUR, totalMinutes % MINUTES_IN_HOUR);
    }

    private static int calcDuration(int start, int end)
    {
        int duration = end - start;
        if (duration < 0)   //If duration is negative, the end is in the next day
            duration += HOURS_IN_DAY * MINUTES_IN_HOUR;
        return duration;
    }
}
