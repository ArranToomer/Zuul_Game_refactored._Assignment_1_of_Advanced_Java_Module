package amt39.gameInitialiser;

import amt39.gameManagement.DisplayText;
import amt39.gameManagement.GameManager;
import amt39.gameManagement.GameRepository;
import amt39.gameManagement.body.*;
import amt39.gameManagement.enums.BodyWord;
import amt39.gameManagement.enums.CommandWord;
import amt39.gameManagement.enums.DirectionWord;
import amt39.userInterfaces.PlayerInterface;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This class extends GameInitialiser and initialises the objects
 * required to begin the game.
 * <p>
 * This class overrides the empty method(additionalSetup()) inherited
 * from GameInitialiser to display some welcome text to any new user of the game.
 *
 * @author (Arran Toomer)
 * @version (1)
 */
public class ZuulInitialiser extends GameInitialiser {
    GameRepository repository = GameRepository.getInstance();
    BodyFactory factory = new BodyFactory();

    /**
     * Constructor for objects of class ZuulInitialiser
     */
    public ZuulInitialiser() {
        super();
        setupAll();
        GameManager.getInstance();
    }

    /**
     * calls all methods needed to setup the game
     */
    @Override
    public void setupAll() {
        setupRooms();
        setupItems();
        this.setupNPCs(); //currently does not perform any function
        setupPlayers();
    }

    /**
     * sets up all rooms required by using the BodyFactory class to create the rooms,
     * and sends them to GameRepository for storage
     */
    @Override
    protected void setupRooms() {

        Set<Body> roomSet = new HashSet<>();

        //Make all the Rooms in the Game.
        Room outside = (Room) factory.reifyBody(BodyWord.ROOM, "outside");
        outside.setRoomDescription("outside the main entrance of the university.");

        Room theatre = (Room) factory.reifyBody(BodyWord.ROOM, "theatre");
        theatre.setRoomDescription("in a lecture theatre.");

        Room pub = (Room) factory.reifyBody(BodyWord.ROOM, "pub");
        pub.setRoomDescription("in the campus pub.");

        Room lab = (Room) factory.reifyBody(BodyWord.ROOM, "lab");
        lab.setRoomDescription("in a computing lab.");

        Room office = (Room) factory.reifyBody(BodyWord.ROOM, "office");
        office.setRoomDescription("in the computing admin office.");

        // Initialise room exits.

        outside.setExit(DirectionWord.EAST, theatre);
        outside.setExit(DirectionWord.SOUTH, lab);
        outside.setExit(DirectionWord.WEST, pub);

        theatre.setExit(DirectionWord.WEST, outside);

        pub.setExit(DirectionWord.EAST, outside);

        lab.setExit(DirectionWord.NORTH, outside);
        lab.setExit(DirectionWord.EAST, office);

        office.setExit(DirectionWord.WEST, lab);


        //Add the rooms to GameRepository via the roomSet set

        roomSet.add(outside);
        roomSet.add(theatre);
        roomSet.add(pub);
        roomSet.add(lab);
        roomSet.add(office);

        repository.addBodyList(roomSet); //send all the rooms to GameRepository.

    }

    /**
     * sets up all items required by using the BodyFactory class to create the items,
     * and sends them to GameRepository for storage
     */
    @Override
    protected void setupItems() {
        Item item1 = (Item) factory.reifyBody(BodyWord.ITEM, "notebook");

        item1.setItemDescription("A dusty old book.");
        item1.setItemWeight(2);

        //Get the required rooms from the repository.
        Room room = (Room) repository.getBody("outside");
        room.addItem(item1);
        repository.addBody(item1);
    }

    /**
     * sets up all players required by using the BodyFactory class to create the players,
     * and sends them to GameRepository for storage
     */
    @Override
    protected void setupPlayers() {
        Player player1 = (Player) factory.reifyBody(BodyWord.PLAYER, "Player1");
        player1.makeInventory(10);

        repository.addMotile(player1);
        PlayerInterface playerInt = new PlayerInterface(player1);
        Room room = ((Room) repository.getBody("outside"));
        player1.setCurrentRoom(room);

        repository.addUserInterface(playerInt);
        additionalSetup();
        playerInt.start();

    }

    /**
     * sets up all NPCs by using the BodyFactory class to create the NPCs,
     * and sends them to GameRepository for storage
     */
    @Override
    protected void setupNPCs() {

    }

    /**
     * adds any further requirements need for Zuul setup. This currently contains the welcome message seen
     * by any user when they first start Zuul.
     */
    public void additionalSetup() {
        DisplayText.getInstance().displayText("Welcome to the World of Zuul!" + "\n" +
                "World of Zuul is a new and mildly boring, yet ever improving adventure game." + "\n" +
                "To play the game simply type your commands and press enter." + "\n" +
                "The valid command words are: " + CommandWord.commandList() + "\n" +
                "If you require help throughout the game, then please type 'help'.");
    }
}
