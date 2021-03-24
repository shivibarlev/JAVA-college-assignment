package Exercises;

import java.util.ArrayList;

public class CommandFactory
{
    public Command getCommand(String [] arguments)
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
        return null;
    }
}
