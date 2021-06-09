package amt39.gameInitialiser;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This abstract class is a template for initialising the objects in the
 * game. This class is designed so that a developer can easily create a different
 * (non-Zuul) version of the game without having to modify many parts of the application.
 *
 * @author (Arran Toomer)
 * @version (1)
 */
public abstract class GameInitialiser {

    protected abstract void setupRooms();

    protected abstract void setupItems();

    protected abstract void setupPlayers();

    protected abstract void setupNPCs();

    public abstract void setupAll();

    public void additionalSetup() {
    }
}




