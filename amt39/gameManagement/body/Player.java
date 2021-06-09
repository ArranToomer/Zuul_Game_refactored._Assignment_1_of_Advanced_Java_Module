package amt39.gameManagement.body;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * Class Player is used to create players of the game. This includes the main
 * player of the game as well as any multiplayer functionality.
 * <p>
 * This class can be extended by any NPCs, but does not have to be.
 *
 * @author (Arran Toomer)
 * @version (1)
 */


public class Player extends Motile implements ItemDealer {
    private Inventory inventory;

    /**
     * Initialises a Player object with a name.
     *
     * @param playerName the name of the Player
     */
    public Player(String playerName) {

        super(playerName);
    }

    /**
     * Makes an inventory for the Player object.
     *
     * @param capacity the maximum weight the Player can carry
     */
    public void makeInventory(int capacity) {
        inventory = new Inventory();
        inventory.makeMotileInv(this.getName(), capacity);

    }

    /**
     * Gets the specified item from  the Players inventory.
     *
     * @param itemString The name of the Item
     * @return an Item object that corresponds with the itemString, or null if there
     * is no correspondence
     */
    @Override
    public Item getItem(String itemString) {

        return inventory.getItem(itemString);

    }

    /**
     * Drops an Item into the current room of the Player.
     *
     * @param item to be dropped in the current Room
     * @return true if drop succeeds, or false otherwise
     */
    public boolean dropItem(Item item) {
        return inventory.dropItemInRoom(item, getCurrentRoom());

    }

    /**
     * Adds an Item object the the player's inventory.
     *
     * @param item item to be added to the Player's inventory
     * @return true if Item successfully added
     */
    public boolean addItem(Item item) {
        return inventory.addItem(item);
    }

    /**
     * Check to see if the Player has an Item
     *
     * @param item to be checked again Player's inventory
     * @return true if Player has Item.
     */
    @Override
    public boolean containsItem(String item) {
        return inventory.containsItem(item);
    }

    /**
     * Removes an Item from the Player's Inventory.
     *
     * @param item Item to be removed from Player
     * @return Item removed, or null if no Item was removed.
     */
    @Override
    public Item removeItem(Item item) {
        return inventory.removeItem(item);
    }

    /**
     * Grants access to the Player's inventory.
     *
     * @return the Player object's inventory
     */

    public Inventory getInventory() {
        return inventory;

    }

}
