package Exercises;

import Command.Command;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Scanner;


/**
 * A class responsible for running the program.
 */
public class Prog
{
    /**
     * @param reader holds the stream we get data from the user through.
     */
    String[] arguments;
    static Scanner reader = new Scanner(System.in);
    boolean finish = false;
    Command command;


    /**
     * This function runs the actual program, starts a loop to get commands from the user and stops after user enters 'q'.
     * @param
     * @return
     */
    public void run()
    {
        this.finish = false;
        System.out.println("Please enter all arguments: <command> <url> <list of arguments>\n" + "<command>: one character (mandatory)\n" +
                "<url>: a string (mandatory)\n" +
                "<list of arguments>: a list of string separated by spaces, possibly empty\n" + "Press q if you would like to stop the program.");

        arguments = reader.nextLine().split(" ");

        while(!arguments[0].equalsIgnoreCase("q"))
        {
            this.command = new CommandFactory().getCommand(arguments);
            if(this.command != null)
                if(checkURL(arguments[1]))
                    System.out.println(this.command.action());

            System.out.println("Please enter all arguments: <command> <url> <list of arguments>\n" + "<command>: one character (mandatory)\n" +
                    "<url>: a string (mandatory)\n" +
                    "<list of arguments>: a list of string separated by spaces, possibly empty\n" + "Press q if you would like to stop the program.");

            arguments = reader.nextLine().split(" ");
        }
        this.finish = true;
    }


    /**
     * This function is responsible of checking the url provided by the user, making sure it exists and doesnt time out.
     * @param url holds te URL provided by the user.
     * @return true if the URL is good, false if the URL is bad.
     */
    public boolean checkURL(String url)
    {
        try
        {
            Document doc = Jsoup.connect(url).get();
        }
        catch (MalformedURLException e)
        {
            System.out.println("bad url");
            return false;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("bad url");
            return false;
        }
        catch (SocketTimeoutException e)
        {
            System.out.println("error");
            return false;
        }
        catch (IOException e)
        {
            System.out.println("error");
            return false;
        }

        return true;
    }

    /**
     * This function returns true if the program should be done running and false if not.
     * (used to check if Main should restart the program in case of some error that caused it to stop)
     * @return true if program is done running, false if not.
     */
    public boolean isDone()
    {
        return this.finish;
    }
}
