package Command;

/**
 * A command interface, the user of this interface implements the action method that the command must execute.
 */
public interface Command {
    /**
     * Performs the action required by the specific command.
     * @return true or false according to the command test.
     */
    boolean action();
}
