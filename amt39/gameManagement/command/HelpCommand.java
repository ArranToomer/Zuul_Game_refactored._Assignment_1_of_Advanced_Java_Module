package amt39.gameManagement.command;

import amt39.gameManagement.enums.CommandWord;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class contains the necessary code to execute the 'help' command word
 * and is executed in the GameManager class.
 * <p>
 * The 'help' command informs the user of all relevant game information such as
 * any items or possible exits. This class also reiterates the syntax for typing used
 * in the game.
 */
public class HelpCommand extends Command {

    /**
     * Displays a message to the user detailing how to correctly type command lines and
     * what the valid command words are.
     *
     * @return A message(String) detailing how to use command words
     */
    @Override
    protected String initiateCommand() {


        StringBuilder message = new StringBuilder("1. The first word typed must be a valid command word. " + "\n" +
                "2. Do not type any additional words. e.g. 'take the notebook' is incorrect. 'take notebook' is correct. " + "\n" +
                "3. The valid command words are: " + CommandWord.commandList());

        return message.toString();
    }
}
