package amt39.gameManagement.command;

import amt39.gameManagement.body.Motile;
import amt39.gameManagement.body.Room;
import amt39.gameManagement.enums.DirectionWord;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class contains the necessary code to execute the 'goRoom' command word
 * and is executed in the GameManager class.
 * <p>
 * The 'goRoom' command attempts to mover the user into the location requested
 * via the second command word String.
 * There are checks to ensure that the second word is a valid direction, and
 * to make sure that the current location has the desired exit.
 *
 * @author (Arran Toomer)
 * @version (1)
 */
public class GoRoomCommand extends Command {

    /**
     * Constructor for objects of class GoRoomCommand
     *
     * @param secondWord is a String that names the direction of travel
     */
    public GoRoomCommand(String secondWord) {
        setSecondWord(secondWord);

    }

    /**
     * Try going in the direction specified by the secondWord. If there is an exit, enter the new room.
     *
     * @return a message(String) to the user of this command object updating them of the outcome
     */
    @Override
    protected String initiateCommand() {

        String StringDirection = getSecondWord(); //Get the secondWord that wil act, if valid, as the direction of travel.
        Motile user = getUser();

        if (user == null) {
            return ("variable user in GoCommand is null");
        }

        // test to see if secondWord is null.
        if (StringDirection == null) {
            // if there is no second word, we don't know where to go
            return ("Go where?");

        }

        //check that the second word is a valid direction
        if (!DirectionWord.isDirection(getSecondWord())) {
            return (StringDirection + " is not a valid direction.");
        }

        Room nextRoom = user.getCurrentRoom().getExitRoom(DirectionWord.getDirectionWord(StringDirection));

        // Try to leave current room.
        if (nextRoom == null) {
            return ("There is no entrance!");

        } else {
            user.setCurrentRoom(nextRoom); //update the user's room to the new one

            return (nextRoom.getRoomInfo()); //Display to the user of this command object the new room info

        }
    }

}

