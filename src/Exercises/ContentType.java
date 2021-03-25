package Exercises;

import java.util.ArrayList;

public class ContentType extends BaseCommand
{
    ArrayList<String> args = new ArrayList<>();

    public ContentType(String[] arguments)
    {
        super(arguments);
        for(int i = 2; i < arguments.length; i++)
            args.add(arguments[i]);
    }

    @Override
    public boolean execute()
    {
        return true;
    }
}
