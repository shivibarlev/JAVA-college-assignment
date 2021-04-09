package Command;


/**
 * A base class for command objects, implementing the command interface.
 */
public abstract class BaseCommand implements Command
{
    String command;
    String url;

    /**
     * Class constructor, builds the BaseCommand object.
     * @param arguments holds arguments received from the user, command and URL.
     */
    public BaseCommand(String [] arguments)
    {
        this.command = arguments[0];
        this.url = arguments[1];
    }

    /**
     * Abstract method, for each command class to implement.
     * @return true or false, depending on test results.
     */
    @Override
    public abstract boolean action();
}
