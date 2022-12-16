package pairmatching.domain;

import java.util.Arrays;

public enum Command {
    MATCHING("1"),
    CHECKING("2"),
    INITIALIZING("3"),
    QUITTING("Q");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static Command valueOfCommand(String inputCommand) {
        return Arrays.stream(values())
                .filter(value -> inputCommand.equals(value.getCommand()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("[ERROR] %s는 기능이 아닙니다.", inputCommand)));
    }

    public String getCommand() {
        return command;
    }

    public boolean isCommandOf(Command command) {
        return this.command.equals(command.getCommand());
    }
}
