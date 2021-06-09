package amt39.gameManagement.body;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * Abstract class Motile is a template for characters(players, NPCs etc)
 * within the game. This class allows a character to move between locations
 * within the game.
 * <p>
 * This class is the parent to Player.
 *
 * @author (Arran Toomer)
 * @version (1)
 */
public abstract class Motile extends Body {
    private Room currentRoom; //the current room of the Motile

    /**
     * Constructor for Motile class.
     *
     * @param name the name of the Motile
     */
    public Motile(String name) {

        super(name);
    }

    /**
     * Get the current Room of the Motile.
     *
     * @return the current room of the Motile
     */
    public final Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the Motile's location.
     *
     * @param currentRoom the current room of the Motile
     */
    public void setCurrentRoom(Room currentRoom) throws NullPointerException {
        if (currentRoom == null) {
            throw new NullPointerException("param currentRoom(Room) is null. Class: Motile, method: setCurrentRoom");
        }
        this.currentRoom = currentRoom;
    }

}