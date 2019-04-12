package Package;

/**
 * Interface for commands
 */
public interface Command {

    /**
     * Do a command
     *
     * @return String
     */
    String execute();

    /**
     * Undo a command
     */
    void undo();
}
