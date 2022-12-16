package pairmatching.controller.command;

import java.util.Arrays;

public enum MainCommand {
    MATCHING("1"),
    CHECKING("2"),
    INITIALIZING("3"),
    QUITTING("Q");

    private static final String ERROR_MESSAGE = "[ERROR] %s는 기능이 아닙니다.\n";
    private final String command;

    MainCommand(String command) {
        this.command = command;
    }

    public static MainCommand valueOfCommand(String inputCommand) {
        return Arrays.stream(values())
                .filter(value -> inputCommand.equals(value.getCommand()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, inputCommand)));
    }

    public String getCommand() {
        return command;
    }

    public boolean isCommandOf(MainCommand command) {
        return this.command.equals(command.getCommand());
    }
}
