package Exercises;

import java.util.ArrayList;

public class CommandFactory
{
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
