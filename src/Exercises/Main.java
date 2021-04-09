package Exercises;
import java.util.Scanner;

/**
 * This is the main class, starts the program and keeps it running.
 */
public class Main
{
    /**
     * This function is the main class constructor.
     * @param args holds arguments passed to the program by the user.
     */
    public static void main(String[] args)
    {
        Prog program = new Prog();
        while(!program.isDone())
            program.run();
    }
}
