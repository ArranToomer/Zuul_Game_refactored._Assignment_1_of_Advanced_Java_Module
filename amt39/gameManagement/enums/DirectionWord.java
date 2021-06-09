package amt39.gameManagement.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This Enum holds all valid direction words for the game along with a
 * string in a particular language.
 *
 * @author (Arran Toomer)
 * @version (1)
 */
public enum DirectionWord {
    NORTH("north"), EAST("east"), SOUTH("south"), WEST("west");

    private final String directionString;

    /**
     * Initialise with the corresponding command string.
     *
     * @param directionString the direction String
     */
    DirectionWord(String directionString) {
        this.directionString = directionString;
    }

    /**
     * indicates whether the param is a valid direction
     *
     * @param aString the direction to be tested
     * @return true if aString is a valid direction, or false otherwise
     */
    public static boolean isDirection(String aString) {

        Map<String, DirectionWord> validDirections = new HashMap<>();
        for (DirectionWord direction : DirectionWord.values()) {
            {
                validDirections.put(direction.toString(), direction);
            }
        }
        return validDirections.containsKey(aString);
    }

    /**
     * returns the DirectionWord that corresponds with the parameter
     *
     * @param directionString The direction as a String
     * @return the DirectionWord that corresponds with the parameter,
     * or null if no correspondence
     */
    public static DirectionWord getDirectionWord(String directionString) {

        DirectionWord direction = null;
        for (DirectionWord direct : DirectionWord.values()) {
            if (direct.toString().equals(directionString)) {

                direction = direct;
            }

        }
        return direction;
    }

    /**
     * @return The command word as a string.
     */
    public String toString() {
        return directionString;
    }

}