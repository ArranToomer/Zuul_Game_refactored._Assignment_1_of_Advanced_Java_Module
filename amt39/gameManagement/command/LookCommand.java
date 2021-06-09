package amt39.gameManagement.command;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class contains the necessary code to execute the 'look' command word
 * and is executed in the GameManager class.
 * <p>
 * The 'look' command describes to the user all relevant info relating to their
 * current location.
 */
public class LookCommand extends Command {

    /**
     * Displays to the user of this look command word a description of their current location.
     *
     * @return a message(String) describing the relevant features of the user's current room
     */
    @Override
    protected String initiateCommand() {
        return getUser().getCurrentRoom().getRoomInfo();
    }
}
