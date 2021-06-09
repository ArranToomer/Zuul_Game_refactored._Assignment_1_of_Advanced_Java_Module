package amt39.gameManagement.command;

import amt39.gameManagement.body.Item;
import amt39.gameManagement.body.Player;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class contains the necessary code to execute the 'drop' command word
 * and is executed in the GameManager class.
 * <p>
 * The 'drop' command attempts to drop the requested item into the current location
 * of the user. There are checks to ensure that the user has the item.
 *
 * @author (A Toomer)
 * @version (a version number or a date)
 */

public class DropCommand extends Command {
    /**
     * Constructor for objects of class DropCommand
     *
     * @param secondWord is a String that names the Item to be dropped
     */
    public DropCommand(String secondWord) {
        setSecondWord(secondWord);

    }

    /**
     * Tries to drop the item. There are checks for the following:
     * 1) that the secondWord is a valid String i.e. not null. 2) That the item is
     * in the user's inventory.
     *
     * @return a message (String) that informs the user of what happened
     */
    @Override
    protected String initiateCommand() {

        Player user = (Player) getUser();
        String itemString = getSecondWord();

        if (getSecondWord() == null) {
            //if there is no second word, we don't know what to take...
            return "Drop what?";

        }

        if (!user.getInventory().containsItem(itemString)) {
            //The item is not in user's inventory
            return "No " + itemString + " to drop ";

        }
        Item itemReal = user.getItem(itemString);
        if (user.dropItem(itemReal)) {

            user.getCurrentRoom().addItem(itemReal);
            user.removeItem(itemReal);
            return "You have successfully dropped the " + itemString;
        }
        return "";
    }

}

