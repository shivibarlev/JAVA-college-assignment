package Exercises;

import java.io.IOException;
import java.util.Scanner;

public class Prog
{
    String[] arguments;
    static Scanner reader = new Scanner(System.in);
    boolean finish = false;

    public void run()
    {
        this.finish = false;
        System.out.println("Please enter all arguments: <command> <url> <list of arguments>\n" + "<command>: one character (mandatory)\n" +
                "<url>: a string (mandatory)\n" +
                "<list of arguments>: a list of string separated by spaces, possibly empty\n" + "Press q if you would like to stop the program.");

        arguments = reader.nextLine().split(" ");

        while(!arguments[0].equalsIgnoreCase("q"))
        {
            System.out.println(new CommandFactory().getCommand(arguments).action());

            System.out.println("Please enter all arguments: <command> <url> <list of arguments>\n" + "<command>: one character (mandatory)\n" +
                    "<url>: a string (mandatory)\n" +
                    "<list of arguments>: a list of string separated by spaces, possibly empty\n" + "Press q if you would like to stop the program.");

            arguments = reader.nextLine().split(" ");
        }
        this.finish = true;
    }

    public boolean isDone()
    {
        return this.finish;
    }
}
