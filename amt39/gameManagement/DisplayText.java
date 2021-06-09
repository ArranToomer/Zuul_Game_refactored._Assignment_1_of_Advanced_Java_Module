package amt39.gameManagement;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This is a singleton class used as the central means to print out text
 * that is relevant to any player of "World of Zuul".
 * <p>
 * This class is the only class where System.out.println() occurs. This makes it
 * easier to add other types of user interface, such as GUI based.
 *
 * @author Arran Toomer
 * @version 1
 */
public class DisplayText {

    private final static DisplayText displayInstance = new DisplayText();

    /**
     * a private constructor in order to ensure that DisplayText is a singleton
     */
    private DisplayText() {
    }

    /**
     * Returns a singleton object of class DisplayText
     *
     * @return the singleton DisplayText object
     */
    public static DisplayText getInstance() {
        return displayInstance;
    }

    /**
     * displays text to the user via System.out.println
     *
     * @param text The text to be displayed
     */
    public void displayText(String text) {

        text = refineTextEnd(text);

        System.out.println();
        System.out.println(text);
    }

    /**
     * used to ensure the end of a text String follows correct formatting rules.
     *
     * @param text The text that's to be formatted
     * @return the formatted text
     */
    public static String refineTextEnd(String text) {

        String refined = text.trim(); // trim spaces from the ends of the text
        int length = refined.length(); // copies the last char from the text

        if (length != 0) {  //if length is 0 then deducting a char will crash the application

            char last = refined.charAt(length - 1); // copies the final char of the text

            Set<Character> valid = new HashSet<>();
            Collections.addAll(valid, '!', '?', ':', '>', '.');
            //a set of all chars that are a valid end to the text String

            Set<Character> replace = new HashSet<>();
            Collections.addAll(replace, ',');
            // a set of all chars that need to be replaced with a '.'

            if (valid.contains(last)) {
                //if 'last' matches with a char in 'valid' set then we do not need to format any further
                return refined;
            }
            if (!valid.contains(last) && !replace.contains(last)) {
                //if true then 'last' is not contained in either of the sets, so add '.'
                refined = refined.substring(0, length) + '.';
            } else {
                //only possibility is that 'last' is contained within the 'replace' set, so we replace last with '.'
                refined = refined.substring(0, length - 1) + '.';
            }
        }
        return refined;
    }

}