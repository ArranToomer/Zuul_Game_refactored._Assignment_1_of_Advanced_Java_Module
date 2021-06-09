package amt39.userInterfaces;

import amt39.gameManagement.command.Command;
import amt39.gameManagement.command.CommandFactory;
import amt39.gameManagement.enums.CommandWord;

import java.util.Scanner;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * interprets the line as a three word command.
 * <p>
 * This parser can create a Command object from any user input. If the first word is
 * a valid CommandWord then this parser instantiates the relevant Command object.
 * If the first word is not recognised as a valid CommandWord, or has a null value, then we
 * create an UNKNOWN Command.
 *
 * @author Michael Kolling and David J. Barnes. Modified by Arran Toomer (2020)
 * @version 1
 */
public class Parser {

    private final CommandFactory cManager;
    private final Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() {
        cManager = new CommandFactory();
        reader = new Scanner(System.in);
    }

    /**
     * interprets user input and turns it into a Command object that corresponds with
     * the first word typed, or if first word unknown it creates an UnknownCommand object.
     *
     * @return The next command from the user as a Command Object.
     */
    public Command getCommand() {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;
        String word3 = null;


       // DisplayText.getInstance().displayText(">");     // print prompt

        inputLine = reader.nextLine();

        // Find up to three words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {

            word1 = tokenizer.next(); // get first word
            word1 = formatText(word1); //

            if (tokenizer.hasNext()) {
                word2 = tokenizer.next(); // get second word

                word2 = formatText(word2);
            }
            if (tokenizer.hasNext()) {
                word3 = tokenizer.next();      // get third word
                word3 = formatText(word3);
                // note: we just ignore the rest of the input line.
            }
        }
        return cManager.reifyCommand(CommandWord.getCommandWord(word1), word2, word3);
            // We have returned the input line but turned the first word into a CommandWord.
    }

    /**
     * formats user input in order for it to be interpreted by all parts of the application.
     *
     * @param text The String to be cleaned
     * @return the param as all lower case, and no spaces at the ends
     */
    public String formatText(String text) {
        String clean = text.toLowerCase();
        return clean.trim();


    }
}