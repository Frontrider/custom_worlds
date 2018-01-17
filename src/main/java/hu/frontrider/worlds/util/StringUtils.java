package hu.frontrider.worlds.util;

public class StringUtils {

    //method to clean up strings before using them in registries.
    //Makes sure, that the user needs not to care about setting it.
    public static String clean(String input)
    {
        return input.toLowerCase().replace(" ","_");
    }
}
