package pairmatching.domain.command;

import java.util.Arrays;

public enum MainCommand {
    MATCHING("1"),
    FIND("2"),
    INIT("3"),
    EXIT("Q");

    private final String command;

    MainCommand(final String command) {
        this.command = command;
    }

    public static MainCommand parseMainCommand(String inputCommand) {
        return Arrays.stream(values())
            .filter(mainCommand -> mainCommand.command.equals(inputCommand))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 기능입니다."));
    }
}