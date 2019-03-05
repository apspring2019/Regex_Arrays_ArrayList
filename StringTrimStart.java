public class StringTrimStart
{
    public static void main(String[] args)
    {
        System.out.println(trimStringStart("xxxxxsalam", 'x'));
        System.out.println(trimStringStart("        hello"));
    }

    private static String trimStringStart(String str)
    {
        return str.replaceFirst("^\\s*", "");
    }

    /***
     * Returns a string without any leading character in the list
     * @param str the string to be trimmed
     * @param chars the list of characters
     * @return the trimmed string
     */
    private static String trimStringStart(String str, char... chars)
    {
        return str.replaceFirst("^[" + new String(chars) + "]*", "");
    }
}
