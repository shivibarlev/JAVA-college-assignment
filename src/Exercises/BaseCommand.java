package Exercises;

import java.util.ArrayList;

public class BaseCommand implements Command
{
    String command;
    String url;
    ArrayList<String> args = new ArrayList<>();

    public BaseCommand(){}

    public BaseCommand(String [] arguments)
    {
        command = arguments[0];
        url = arguments[1];
        for(int i = 2; i < arguments.length; i++)
            args.add(arguments[i]);

    }
    @Override
    public boolean execute(){}
}
