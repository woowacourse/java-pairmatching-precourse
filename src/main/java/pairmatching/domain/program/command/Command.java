package pairmatching.domain.program.command;

import java.util.Arrays;

public enum Command {
    MATCHING("1"),
    CHECKING("2"),
    RESETTING("3"),
    QUITTING("Q");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static boolean contains(String command) {
        return Arrays.stream(values())
                .anyMatch(value -> command.equals(value.getCommand()));
    }
}
