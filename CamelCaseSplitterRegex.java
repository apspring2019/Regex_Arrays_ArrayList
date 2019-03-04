import java.util.Arrays;
import java.util.Scanner;

public class CamelCaseSplitterRegex
{
    //Simply splits the camelCase string using regex lookahead. Example:
    //previousIndex => previous, Index.
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
            System.out.println(Arrays.toString(scanner.next().split("(?=[A-Z])")));
    }
}
