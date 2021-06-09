package amt39.gameManagement.enums;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This Enum holds all valid command words for the game along with a
 * string in a particular language.
 *
 * @author Michael Kölling and David J. Barnes. Modified by A Toomer.
 * @version 1
 */
public enum CommandWord {
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("unknown"),
    LOOK("look"), TAKE("take"), DROP("drop"), GIVE("give");

    // The command string.
    private final String commandString;

    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    /**
     * takes a command word String and replaces it with the corresponding CommandWord or
     * with UnknownCommand if String is not a valid command.
     * @param commandString the String to be turned into a Command object
     * @return Command object corresponding to the param
     */
    public static CommandWord getCommandWord(String commandString) {
        CommandWord firstWord = UNKNOWN; //If the parameter is null or not recognised we create an UNKNOWN commandWord.

        for (CommandWord command : CommandWord.values()) {
            if (command.toString().equals(commandString)) {

                firstWord = command;
            }

        }
        return firstWord;
    }

    /**
     *
     * @return
     */
    public static String commandList() {

        StringBuilder message = new StringBuilder();

        for (CommandWord command : CommandWord.values()) {
            if (command.equals(CommandWord.UNKNOWN)) {
                //do Not print out '?', which is the String used to represent UNKNOWN
            } else {
                message.append(command.toString()).append(", ");
            }
        }
        return message.toString();
    }

    /**
     * @return The command word as a string.
     */
    @Override
    public String toString() {
        return commandString;
    }

}
