package Exercises;

import java.io.IOException;

public interface Command {
    boolean execute() throws IOException;
}
