package amt39.gameManagement.command;

import amt39.gameManagement.DisplayText;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class contains the necessary code to execute the 'quit' command word
 * and is executed in the GameManager class.
 * <p>
 * The 'quit' command ends the user's current game session.
 */
public class QuitCommand extends Command {
    /**
     * Quits the game for the user of this command object.
     *
     * @return an empty String
     */
    protected String initiateCommand() {
        DisplayText.getInstance().displayText("Thank you for playing. Good bye.");
        System.exit(0);
        return ""; //This line is never reached. It exists because every Command must have a return String.
    }
}
