package amt39.gameManagement.command;


import amt39.gameManagement.enums.CommandWord;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class creates a concrete Command by using the firstWord typed by the user
 * and creates the corresponding Command object.
 *
 * @author A Toomer
 * @version 1
 */
public class CommandFactory {


    /**
     * Creates a concrete Command object by instantiating one of Command's child
     * classes that correspond with the CommandWord given as a parameter.
     *
     * @param firstWord  the CommandWord that is used to determine what implementation of Command is required.
     * @param secondWord an optional String used as a parameter by some Command implementations.
     * @param thirdWord  an optional String used as a parameter by some Command implementations.
     * @return the Command object that matches the parameter 'firstWord'.
     */
    public Command reifyCommand(CommandWord firstWord, String secondWord, String thirdWord) {

        Command reified = null;

        switch (firstWord) {
            case GO:
                reified = new GoRoomCommand(secondWord);
                break;
            case QUIT:
                reified = new QuitCommand();
                break;
            case HELP:
                reified = new HelpCommand();
                break;
            case TAKE:
                reified = new TakeCommand(secondWord);
                break;
            case DROP:
                reified = new DropCommand(secondWord);
                break;
            case UNKNOWN:
                reified = new UnknownCommand();
                break;
            case GIVE:
                reified = new GiveCommand(secondWord, thirdWord);
                break;
            case LOOK:
                reified = new LookCommand();
                break;

        }
        return reified;

    }
}
