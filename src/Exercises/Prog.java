package Exercises;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.print.Doc;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Prog
{
    String[] arguments;
    static Scanner reader = new Scanner(System.in);
    boolean finish = false;
    Command command;
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


    public boolean isDone()
    {
        return this.finish;
    }
}
