package Exercises;

import java.util.ArrayList;

public class CheckLang extends BaseCommand
{
    ArrayList<String> args = new ArrayList<>();

    public CheckLang(String[] arguments)
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
