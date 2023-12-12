package pairmatching.domain;

import java.util.Arrays;
import pairmatching.exception.ExceptionMessage;

public enum OptionCommand {
    MATCHING("1"),
    CHECK("2"),
    RESET("3"),
    QUIT("Q");

    private final String command;

    OptionCommand(String command) {
        this.command = command;
    }

    public static OptionCommand from(String input) {
        return Arrays.stream(OptionCommand.values())
                .filter(optionCommand -> optionCommand.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        ExceptionMessage.INVALID_COMMAND.getMessage()));
    }
}
