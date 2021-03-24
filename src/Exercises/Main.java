package Exercises;
import java.util.Scanner;


public class Main
{
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        String[] arguments;

        System.out.println("Please enter all arguments: <command> <url> <list of arguments>\n" + "<command>: one character (mandatory)\n" +
                    "<url>: a string (mandatory)\n" +
                    "<list of arguments>: a list of string separated by spaces, possibly empty\n");

        arguments = reader.nextLine().split(" ");

    }
}
