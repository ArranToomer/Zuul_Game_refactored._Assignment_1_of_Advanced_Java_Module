package amt39.gameManagement.command;

import amt39.gameManagement.body.Motile;

/**
 * This class is part of the extended "World of Zuul" application.
 * "World of Zuul" is a simple, text based adventure game.
 * <p>
 * This abstract class is a template for concrete implementations of user
 * commands, which are made into objects by the CommandFactory class.
 *
 * @author Arran Toomer
 * @version 1
 */
public abstract class Command {
    private Motile user;
    private String secondWord;
    private String thirdWord;


    public String execute() {

        return initiateCommand();
    }

    protected String getSecondWord() {
        return secondWord;

    }

    protected void setSecondWord(String secondWord) {
        this.secondWord = secondWord;

    }

    protected String getThirdWord() {
        return thirdWord;

    }

    protected void setThirdWord(String thirdWord) {
        this.thirdWord = thirdWord;


    }

    abstract protected String initiateCommand();

    /**
     * returns the user of the relevant command word.
     *
     * @return the user of the relevant command word.
     */
    public Motile getUser() {
        return user;
    }

    /**
     * Sets the Command object up with the Motile who used the command word.
     *
     * @param user The Motile we want to give the Command to.
     */
    public void setUser(Motile user) {

        this.user = user;
    }

}

