package pairmatching.domain;

import java.util.Arrays;
import pairmatching.exception.ExceptionMessage;

public enum RematchingCommand {
    REMATCHING("네"),
    QUIT("아니오");

    private final String command;

    RematchingCommand(String command) {
        this.command = command;
    }

    public static RematchingCommand from(String input) {
        return Arrays.stream(RematchingCommand.values())
                .filter(rematchingCommand -> rematchingCommand.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        ExceptionMessage.INVALID_REMATCHING_COMMAND.getMessage()));
    }

    public String getCommand() {
        return command;
    }
}
