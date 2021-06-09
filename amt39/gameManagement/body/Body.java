package amt39.gameManagement.body;


/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * Class Body is the most general unit in the game. Object would be
 * a better term but that is already in used in Java.
 *
 * @author (Arran Toomer)
 * @version (1)
 */
public abstract class Body {
    private String bodyName; //the name identifying the body

    /**
     * Create an instance of a Body object.
     *
     * @param name the name of the body.
     */
    public Body(String name) {
        bodyName = name;
    }

    /**
     * Retrieves the name of the Body
     *
     * @return the name of this body object
     */
    public String getName() {
        return bodyName;
    }

    /**
     * Sets the name of the Body
     *
     * @param name The new name of the Body
     */
    public void setName(String name) {

        bodyName = name;
    }
}
