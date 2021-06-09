package amt39.gameManagement.command;

import amt39.gameManagement.body.Item;
import amt39.gameManagement.body.Player;
import amt39.gameManagement.body.Room;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class contains the necessary code to execute the 'take' command word
 * and is executed in the GameManager class.
 * <p>
 * The 'drop' command attempts to take an item from the user's current location and checks if
 * the item is too heavy to be taken. If successful, the item is deposited in the user's inventory and
 * removed from the room.
 *
 * @author (A Toomer)
 * @version (1)
 */
public class TakeCommand extends Command {

    /**
     * Constructor for objects of class TakeCommand
     *
     * @param secondWord is a String that names the Item to take.
     */
    public TakeCommand(String secondWord) {
        setSecondWord(secondWord);

    }

    /**
     * The user of this command object attempts to take an item specified by
     * the secondWord of this command object.
     *
     * @return a message(String)informing the user if they were successful in taking the item.
     */
    @Override
    protected String initiateCommand() {
        Player user = (Player) getUser(); // the user of the command
        String itemString = getSecondWord(); //the second command word renamed and turned into a local variable for convenience.
        Room location = user.getCurrentRoom(); //the current location of the user of the command

        if (itemString == null) {
            // if there is no second word, we don't know what to take.
            return "Take what?";

        }
        // Now we obtain the Item with the same name as itemString from the location.
        Item itemReal = location.getItem(itemString);
        if (itemReal == null) {
            //check that the Item exists. If not then inform the user.
            return ("There is no " + itemString + " to take");

        }

        // Next we determine if the Item is too heavy to be stored in the user's inventory.

        int iWeight = itemReal.getItemWeight(); //Get the item weight.
        int inventoryWeight = user.getInventory().getCurrentWeight(); // Get the current weight of the user's inventory.

        //Next we add together iWeight and inventoryWeight to see if the total exceeds the capacity of  the user's inventory.
        if ((inventoryWeight += iWeight) > user.getInventory().getCapacity()) {
            // The player is carrying too much
            return itemString + " is too heavy";

        }
        // OK we can finally pick the item up.
        user.addItem(itemReal);

        //Finally, we make sure the item (or a reference to the item)is no longer in user's current location.
        location.removeItem(itemReal);

        return "You pick up the " + itemString + ". " + itemReal.getItemDescription();


    }

}

