package amt39.gameManagement.body;

import amt39.gameManagement.DisplayText;
import amt39.gameManagement.GameRepository;
import amt39.gameManagement.enums.DirectionWord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  For each existing exit, the room
 * stores a reference to the neighboring room within a HashMap.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Room extends Body implements ItemDealer {

    private final Map<DirectionWord, Room> exits; //a map of exits and their corresponding Rooms.
    private final Inventory inventory;
    private String roomDescription;


    /**
     * Initialise the Room object with a name and description.
     *
     * @param roomName the name of the room
     */
    public Room(String roomName) {

        super(roomName);
        exits = new HashMap<>();
        inventory = new Inventory();

    }

    /**
     * Set one of the Room's exits.
     *
     * @param direction an exit String word
     * @param room      the Room associated with the String
     */
    public void setExit(DirectionWord direction, Room room) {

        if (!exits.containsKey(direction))//if direction is not already mapped
        {
            exits.put(direction, room);
        }
    }

    /**
     * Get the Room that corresponds with the supplied DirectionWord.
     *
     * @param direction The direction of travel
     * @return the Room that lies within the supplied direction
     */
    public Room getExitRoom(DirectionWord direction) {
        return exits.get(direction);
    }

    /**
     * Adds an Item to the Room.
     *
     * @param item Item to be added to the Room.
     * @return true if item added successfully
     */
    @Override
    public boolean addItem(Item item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException("param item(Item) is null. Class: Room, method: addItem");
        }
        return inventory.addItem(item);
    }

    /**
     * Removes an Item from the Room, if the Room contains the item.
     *
     * @param item item to remove from the Room
     * @return the Item removed, or null if no Item removed
     */
    @Override
    public Item removeItem(Item item) {
        if (inventory.containsItem(item.getName())) {
            //inventory.setCurrentWeight( - (item.getItemWeight()));
            return inventory.removeItem(item);
        } else {
            return null;
        }
    }

    /**
     * Gets an item from the Room's inventory
     *
     * @param itemString the name of the item to get
     * @return The Item object
     */
    @Override
    public Item getItem(String itemString) {
        return inventory.getItem(itemString);

    }

    /**
     * Check if the Room contains an Item.
     *
     * @param item to be checked, if contained in Room
     * @return true if the Item is in the Room
     */
    @Override
    public boolean containsItem(String item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException("param item(Item) is null. Class: Room, method: containsItem");
        }
        return inventory.containsItem(item);
    }

    /**
     * Set the description of the Room.
     *
     * @param description The description of the room
     */
    public void setRoomDescription(String description) {
        this.roomDescription = description;
    }

    /**
     * Get a String list of all Items in the room
     *
     * @return a String describing all the Items in the Room
     */
    public String getItemsString() {
        return inventory.getItemList();
    }

    /**
     * Get a String list of all exits for the Room
     *
     * @return a String describing all the exits of the Room
     */
    public String getExitString() {

        String exitString = "";

        for (DirectionWord exit : exits.keySet()) {

            exitString = exitString.concat(exit.toString() + ", ");
        }
        //refine the text.
        return DisplayText.refineTextEnd(exitString);

    }

    /**
     * Get a String list of all the Motile's in the Room
     *
     * @return all Motile's currently in the Room
     */
    public String showMotiles() {

        String roomMotiles = "Players present: ";
        HashSet<Motile> playerSet = (HashSet<Motile>) GameRepository.getInstance().getMotileSet();
        for (Motile player : playerSet) {
            if (player.getCurrentRoom().equals(this)) {
                roomMotiles += player.getName() + ", ";
            }
        }
        return roomMotiles;
    }

    /**
     * Get a String list of all the relevant info relating to the Room.
     *
     * @return the Room's description, any exits, any Items, and any Motiles.
     */
    public String getRoomInfo() {

        return "You are " + roomDescription + "\n" + "The exits are: " + getExitString() + "\n"
                + "Items: " + getItemsString() + "\n" + showMotiles();

    }
}