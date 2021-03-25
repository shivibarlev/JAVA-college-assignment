package Exercises;

import java.util.ArrayList;

public class BaseCommand implements Command
{
    String command;
    String url;

    public BaseCommand(){}

    public BaseCommand(String [] arguments)
    {
        command = arguments[0];
        url = arguments[1];


    }
    @Override
    public boolean execute(){return true;}
}
