package amt39.gameManagement;

import amt39.gameManagement.body.Body;
import amt39.gameManagement.body.Motile;
import amt39.userInterfaces.UserInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This is a singleton class and is the global repository for objects in the game.
 * It allows easy access to any objects that might be required as the application is
 * running.
 *
 * @author (Arran Toomer)
 * @version (1)
 */
public class GameRepository {

    private final static GameRepository repository = new GameRepository();

    private Set<Body> bodyCollection;
    private Set<Motile> motileCollection;
    private List<UserInterface> userBag;

    /**
     * Constructor for objects of class GameRepository
     */
    private GameRepository() {
        bodyCollection = new HashSet<>();
        motileCollection = new HashSet<>();
        userBag = new ArrayList<>();
    }

    /**
     * creates and returns the singleton version of GameRepository
     *
     * @return repository the global access point for this class.
     */
    public static GameRepository getInstance() {
        return repository;

    }

    /**
     * Returns a set of all objects that extend the Motile class.
     *
     * @return playerCollection The set of all Motiles currently in the game.
     */
    public Set getMotileSet() {

        return motileCollection;
    }


    /**
     * Adds a Motile to the Motiles collection
     *
     * @param motile The Motile to be added to the collection
     */
    public void addMotile(Motile motile) throws NullPointerException {
        if (motile == null) {
            throw new NullPointerException("param motile(Motile) is null. Class: GameRepository, method: addMotile");
        }
        motileCollection.add(motile);

    }

    /**
     * gets the Motile that has a name identical with motileString parameter.
     *
     * @param motileString the name of the Motile
     * @return the Player whose name matches the param motileString, or null
     * if there is no match
     */
    public Motile getMotile(String motileString) throws NullPointerException {
        if (motileString == null) {
            throw new NullPointerException("param Motile(String) is null. Class: GameRepository, method: getMotile");
        }
        Motile motileReturn = null;
        for (Motile mot : motileCollection) {

            if (mot.getName().equalsIgnoreCase(motileString)) {

                motileReturn = mot;
            }
        }
        return motileReturn;

    }

    /**
     * used to add any object that extends class Body.
     *
     * @param body the Body to add to bodyCollection
     */
    public void addBody(Body body) throws NullPointerException {
        if (body == null) {
            throw new NullPointerException("param body(Body) is null. Class: GameRepository, method: addBody");
        }
        bodyCollection.add(body);

    }

    /**
     * Adds a collection of Body objects to the bodyCollection set.
     *
     * @param bodySet The set of Body's to be added to the collection
     */
    public void addBodyList(Set<Body> bodySet) throws NullPointerException {
        if (bodySet == null) {
            throw new NullPointerException("param bodyList(List) is null. Class: GameRepository, method: addBodyList");
        }
        {
            for (Body body : bodySet) {

                bodyCollection.add(body);
            }

        }
    }

    /**
     * Get the Body that has a name identical with bodyName parameter.
     *
     * @param bodyName the name of the Body to be returned
     * @return Body, the Body whose name matches the param bodyName, or null
     * if there is no match
     */
    public Body getBody(String bodyName) throws NullPointerException {

        if (bodyName == null) {
            throw new NullPointerException("param bodyName(String) is null. Class: GameRepository, method: getBody");
        }
        Body bodyReturn = null;
        for (Body body : bodyCollection) {

            if (body.getName().equals(bodyName)) {

                bodyReturn = body;
            }
        }
        return bodyReturn;

    }

    /**
     * Adds the relevant userInterface and stores the Player object under the MotileCollection List
     *
     * @param user The userInterface object to be stored
     */
    public void addUserInterface(UserInterface user) {
        userBag.add(user);
        addMotile(user.getUser());
    }

}
