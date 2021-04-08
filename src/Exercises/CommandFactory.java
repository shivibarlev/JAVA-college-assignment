package Exercises;

import Command.*;

/**
 * Class for a command factory, responsible for creating the command classes demanded by the user.
 */
public class CommandFactory
{
    /**
     * This function returns the correct command object the user wanted to call.
     *
     * @param  arguments  a string array that holds the required arguments to create the needed command.
     * @return  the correct command object invoked by the user, null if command doesnt exist.
     */
    public Command getCommand(String [] arguments)
    {
        try
        {
            switch (arguments[0])
            {
                case "t":
                    return new ContentType(arguments);
                case  "w":
                    return new WordSearch(arguments);
                case  "i":
                    return new CheckImg(arguments);
                case  "l":
                    return new CheckLang(arguments);

            }
        }
        catch (Exception e)
        {
            System.out.println("error");
        }
        System.out.println("invalid command");
        return null;
    }
}
