package amt39.gameManagement.command;

import amt39.gameManagement.enums.CommandWord;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * An object of class UnknownCommand is created whenever a user's first word is an invalid command
 * word.
 * <p>
 * The unknownCommand simply informs the user that their first word was not
 * valid.
 */
public class UnknownCommand extends Command {

    /**
     * Informs the user of the command object that the first word entered was not a valid command word, and
     * displays a list of all the valid command words.
     * @return a message(String) that informs the user the first word used was not a valid command word
     */
    @Override
    protected String initiateCommand() {

        StringBuilder message = new StringBuilder("You did not use a valid command word as your first word. " + "\n" +
                "The valid command words are: " + CommandWord.commandList());

        return message.toString();
    }

}

