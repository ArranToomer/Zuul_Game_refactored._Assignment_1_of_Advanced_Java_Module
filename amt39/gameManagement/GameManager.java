package amt39.gameManagement;

import amt39.gameManagement.command.Command;

import java.util.Stack;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class processes commandWord's from any characters ( other Players or NPCs) that might
 * be added in future development, as well as the current player. It places the command
 * requests into a stack, and deals with them one by one by running a continuous loop
 * that checks the stack of possible commands.
 *
 * @author A Toomer
 * @version 1
 */
public class GameManager implements Runnable {


    public static final GameManager gameManager = new GameManager();
    private final GameRepository repository;
    Thread gManagerThread;
    private Stack<Command> commandQueue;
    private boolean running;

    /**
     * Constructor that Initialises fields and starts the thread.
     */
    private GameManager() {

        repository = GameRepository.getInstance();
        commandQueue = new Stack<>();
        gManagerThread = new Thread(this);
        gManagerThread.start();

    }

    /**
     * Creates a singleton instance and provides global access to it.
     *
     * @return The singleton instance of this class
     */
    public static GameManager getInstance() {
        return gameManager;

    }

    /**
     * places a Command object on the command queue
     *
     * @param command The command object to be queued
     */
    public void queueCommand(Command command) {
        commandQueue.add(command);

    }

    /**
     * overrides the run method from Interface Runnable and repeatedly
     * calls the processQueues method.
     */
    @Override
    public void run() {

        running = true;
        while (running) {
            processQueues();

        }

    }

    /**
     * used to end the continuous loop found in the run method. setRunning is not currently
     * used, but is included to make future development of the application easier.
     *
     * @param running is true when we want to continue the game and false otherwise
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * takes a command object from the queue, if there is one present,
     * and gives it to the processCommand method for further processing
     */
    public synchronized void processQueues() {
        //at some point need to add a check to see if player still around. if so then
        //I can quit application.

        if (!commandQueue.isEmpty()) {
            Command currentCommand = commandQueue.pop();
            processCommand(currentCommand);
        }
    }


    /**
     * used to process commands by calling the command's execute method.
     *
     * @param command the command object to be processed
     */
    public synchronized void processCommand(Command command) {
        DisplayText.getInstance().displayText(command.execute());
    }
}
