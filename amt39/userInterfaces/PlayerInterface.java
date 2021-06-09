package amt39.userInterfaces;

import amt39.gameManagement.DisplayText;
import amt39.gameManagement.GameManager;
import amt39.gameManagement.GameRepository;
import amt39.gameManagement.body.Player;
import amt39.gameManagement.command.Command;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class extends UserInterface and sets a player with an interface.
 * This class repeatedly calls the parser and places any command requests
 * to the GeneralManager class for further processing.
 * <p>
 * The loop in method: play() will end when the player uses CommandWord.QUIT.
 *
 * @author (Arran Toomer)
 * @version (a version number or a date)
 */
public class PlayerInterface extends UserInterface implements Runnable {
    private final Player player;
    private final Parser parser;

    /**
     * Constructor for objects of class PlayerInterface
     */
    public PlayerInterface(Player player) {
        addUser(player);
        this.player = player;
        parser = new Parser();
    }

    /**
     * overrides the run method from Runnable and calls the play method.
     */
    @Override
    public void run() {
        play();

    }

    /**
     * starts the play loop for the user and displays the current information of the location they start in.
     */
    public void play() {

        DisplayText display = DisplayText.getInstance();

        display.displayText(getUser().getCurrentRoom().getRoomInfo()); //display the contents of the room
        GameRepository.getInstance().addUserInterface(this); //adds the interface to gameRepository

        // use the Parser to look for user input, then action input by placing it in GameManager's command queue
        while (true) {

            Command command = parser.getCommand();
            command.setUser(player);
            GameManager.getInstance().queueCommand(command);
        }
    }
}
