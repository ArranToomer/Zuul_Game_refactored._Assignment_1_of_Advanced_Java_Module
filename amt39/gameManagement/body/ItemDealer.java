package amt39.gameManagement.body;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This Interface can be used by any class that wants to interact with items in the game.
 *
 * @author (Arran Toomer)
 * @version (1)
 */
public interface ItemDealer {

    /**
     * Check to see if this inventory contains a particular Item
     *
     * @param item The Item object to check
     * @return true if the Inventory does contain the item
     */
    boolean containsItem(String item);


    /**
     * @param item to be removed from the ItemHolder
     * @return item removed
     */
   Item removeItem(Item item);

    /**
     * @param item to be added to the ItemHolder
     * @return true if item added successfully
     */

    boolean addItem(Item item);

    /**
     * @return the items held by the ItemDealer
     */

   Item getItem(String item);
}

