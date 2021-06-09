package amt39.gameManagement.body;

import amt39.gameManagement.DisplayText;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * Class Inventory is used to store items and can add additional
 * functionality by adding a capacity weight limit via the makeMotileInv
 * method.
 *
 * @author Arran Toomer
 * @version 1
 */

public class Inventory implements ItemDealer {

    private Set<Item> itemSet; //the set of items contained in this inventory
    private String ownerString; // The Body that the inventory belongs to.

    private int capacity;
    private int currentWeight;

    /**
     * Initialises an Inventory object with no initial capacity constraints.
     */
    public Inventory() {
        itemSet = new HashSet<>();
    }

    /**
     * Adds a maximum amount of weight that the inventory may hold.
     *
     * @param motile   the name of the motile who owns this inventory object.
     * @param capacity the maximum weight that the inventory can hold.
     */
    public void makeMotileInv(String motile, int capacity) {
        this.capacity = capacity;
        currentWeight = 0;
        addName(motile);

    }

    /**
     * Adds the name of the inventory owner.
     *
     * @param ownerString the name of the inventory's owner.
     */
    public void addName(String ownerString) {
        this.ownerString = ownerString;
    }

    /**
     * Adds an item to the inventory
     *
     * @param item the item to add
     * @return true if the item was added successfully, and false if
     * the capacity is  less than totalWeight + capacity.
     */
    public boolean addItem(Item item) throws NullPointerException {
        if (item == null) {

            throw new NullPointerException
                    ("param item(Item) is null. Class: Inventory, method: addItem");

        } else {
            itemSet.add(item);
            setCurrentWeight(item.getItemWeight());
            return true;
        }
    }

    /**
     * Removes an item from the inventory.
     *
     * @param item an item to be added to the inventory
     * @return the removed Item object if it is found in the inventory, or null
     * if not
     */
    public Item removeItem(Item item) {
        if (itemSet.contains(item)) {

            itemSet.remove(item);

            setCurrentWeight(-(item.getItemWeight()));
            return item;
        } else {
            return null;
        }
    }

    /**
     * Get the capacity of the inventory.
     *
     * @return the capacity of the inventory
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Get the current weight of the inventory.
     *
     * @return the current weight of inventory
     */
    public int getCurrentWeight() {
        return currentWeight;
    }

    /**
     * Adjusts the current weight of the inventory.
     *
     * @param extraWeight the additional weight change
     */
    public void setCurrentWeight(int extraWeight) {
        currentWeight += extraWeight;
    }

    /**
     * Drops an Item into the given Room.
     *
     * @param item     Item to be dropped
     * @param dropRoom room to drop item into
     * @return true if Item successfully dropped.
     */
    public boolean dropItemInRoom(Item item, Room dropRoom) {

        Item removeItem = removeItem(item);

        if (removeItem != null) {

            dropRoom.addItem(removeItem);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets an item from the inventory.
     *
     * @param itemString The name of the item to get.
     * @return the Item object that corresponds to the itemString, or
     * null if there is no such item.
     */
    public Item getItem(String itemString) {
        Item itemSend = null;
        for (Item item : itemSet) {
            if (item.getName().equals(itemString)) {
                itemSend = item;
            }
        }
        return itemSend;
    }

    /**
     * returns all the items currently in the inventory as a String concatenation.
     *
     * @return a string of all items within the inventory.
     */
    public String getItemList() {
        String itemList = " ";

        for (Item item : itemSet) {
            //for each item concatenate the item name to the string
            itemList = itemList.concat(item.getName() + ", ");
        }
        return DisplayText.refineTextEnd(itemList);  //return the itemList

    }

    /**
     * Check to see if the inventory contains a specific Item
     *
     * @param itemString The Item object to check
     * @return true if the Inventory contains the item
     */
    public boolean containsItem(String itemString) {

        for (Item item : itemSet) {
            if (item.getName().equals(itemString)) {
                return true;
            }

        }

        return false;
    }
}