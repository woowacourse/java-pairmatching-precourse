package pairmatching.domain;

import java.util.Arrays;

public enum Command {

    MATCHING("1"), SELECT("2"), INIT("3"), QUIT("Q");

    private final String inputCommand;

    Command(final String inputCommand) {
        this.inputCommand = inputCommand;
    }


    public static Command from(String inputCommand) {
        return Arrays.stream(values())
                .filter(command -> command.inputCommand.equals(inputCommand))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("다시 선택해 주세요."));
    }
}
