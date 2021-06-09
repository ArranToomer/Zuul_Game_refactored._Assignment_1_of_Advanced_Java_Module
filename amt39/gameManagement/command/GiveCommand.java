package amt39.gameManagement.command;

import amt39.gameManagement.GameRepository;
import amt39.gameManagement.body.Item;
import amt39.gameManagement.body.Player;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class contains the necessary code to execute the 'give' command word
 * and is executed in the GameManager class.
 * <p>
 * The 'give' command attempts to give the requested item (second word) to the
 * receiver, who is specified by the third word of the command String.
 * There are checks to ensure that: 1) the user has the item;
 * 2) the receiver exists; 3) that both receiver and giver are in the same location;
 * 4) that the giver and receiver are not identical; 5) that the item is not too
 * heavy for the receiver to pick up.
 *
 * @author (Arran toomer)
 * @version (1)
 */
public class GiveCommand extends Command {

    /**
     * Constructor for objects of class GiveCommand.
     *
     * @param secondWord is a String that names the Item to give.
     * @param thirdWord  is a String that names the receiver of the item(SecondWOrd).
     */
    public GiveCommand(String secondWord, String thirdWord) {
        setSecondWord(secondWord);
        setThirdWord(thirdWord);
    }

    /**
     * @return a message(String) to the user of this command object
     */
    @Override
    protected String initiateCommand() {

        if (getSecondWord() == null) {
            return "Take what?";
        } // if no second word, we don't know what to take

        Player receiver = (Player) GameRepository.getInstance().getMotile(getThirdWord());

        if (receiver == null) {
            return "The " + getThirdWord() + " is not here.";
        }
        //there is no player matching the thirdWord

        //if we got this far we know that there is a receiver for the item.

        Player giver = (Player) getUser();

        String itemString = getSecondWord();

        if (!giver.containsItem(itemString)) {  // The item is not in the giver's inventory
            return "The " + itemString + " is not in " + giver.getName() + "'s inventory";
        }

        if (receiver.equals(giver)) { //checks that the receiver and the giver are NOT the same object.
            return " You cannot give " + itemString + " to yourself";
        }

        if (!receiver.getCurrentRoom().equals(giver.getCurrentRoom())) {  //checks that receiver is in same location
            return "" + receiver.getName() + " is not in the same location as " + giver.getName();
        }

        //after all these checks, we know that the giver has the item and the receiver is in the same location as the giver.
        //next, we check if the receiver has sufficient capacity in their inventory.

        Item itemReal = giver.getItem(itemString); //retrieve the item from the giver
        int iWeight = itemReal.getItemWeight(); //Get the item weight.
        int inventoryWeight = receiver.getInventory().getCurrentWeight(); // Get the current weight of the receiver's inventory.

        //Next we add together iWeight and inventoryWeight to see if the total exceeds the capacity of the receiver's inventory.
        if ((inventoryWeight += iWeight) > receiver.getInventory().getCapacity()) {
            // The receiver is carrying too much
            return itemString + " is too heavy";
        }
        //The giver can now give the item to the receiver.
        receiver.addItem(giver.getItem(itemString));
        giver.removeItem(itemReal);
        return "You have given " + itemString + " to " + getThirdWord();

    }
}