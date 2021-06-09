package amt39.gameManagement.body;

import amt39.gameManagement.enums.BodyWord;


/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * Class BodyFactory implements a simple factory design pattern  capable of creating any
 * objects that inherit from Body.
 * <p>
 * This class uses the BodyWord enum and constructs a concrete Body object that
 * corresponds with the BodyWord.
 *
 * @author Arran Toomer
 */

public class BodyFactory {

    /**
     * A factory method that creates the Body with the associated BodyWord enum type.
     *
     * @param body The BodyWord used to indicate what specific Body object to create.
     * @param name The name of the Body object.
     * @return a concrete Command object
     */
    public Body reifyBody(BodyWord body, String name) {

        Body concrete = null;

        switch (body) {
            case PLAYER:
                concrete = new Player(name);
                break;

            case ROOM:
                concrete = new Room(name);
                break;

            case ITEM:
                concrete = new Item(name);
                break;

            case NPC:

                break;
            case MOTILE:

                break;
        }
        return concrete;

    }
}
