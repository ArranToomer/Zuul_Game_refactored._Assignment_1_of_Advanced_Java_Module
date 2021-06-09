package amt39.userInterfaces;

import amt39.gameManagement.body.Motile;
import amt39.gameManagement.body.Player;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This abstract class is essentially a template for specific implementations of
 * user userInterfaces. This class gives the application greater flexibility by allowing
 * a different playerInterface without the need to modify other parts of the application.
 *
 * @author (Arran Toomer)
 * @version (1)
 */
public abstract class UserInterface implements Runnable {

    private final Thread userInterface;
    private Player player;

    /**
     * Constructor for objects of class PlayerInterface
     */
    public UserInterface() {
        userInterface = new Thread(this);
    }

    /**
     * starts the game by calling the play method
     */
    public void run() {
        play();
    }


    public void start() {
        userInterface.start();
    }


    public abstract void play();

    /**
     * adds a user (player) to a userInterface.
     *
     * @param player The player to be added to the userInterface
     */
    public void addUser(Player player) {
        this.player = player;

    }

    /**
     * @return the player who is using the userInterface
     */
    public Motile getUser() {
        return player;
    }
}
   