package amt39.gameManagement.body;


/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * Class Item represents an item in the game. Items can be interacted
 * with via the valid command words.
 *
 * @author (A Toomer)
 * @version (1)
 */
public class Item extends Body {

    private int itemWeight;
    private String itemDescription;

    /**
     * Creates an Item object
     *
     * @param name the name of the item
     */
    public Item(String name) {
        super(name);
    }


    /**
     * Get the amount the Item object weighs.
     *
     * @return the weight of the item
     */
    public int getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(int itemWeight) {

        this.itemWeight = itemWeight;
    }

    /**
     * Get the Item object's description
     *
     * @return the item's description
     */
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String description) {

        itemDescription = description;
    }
}
    


