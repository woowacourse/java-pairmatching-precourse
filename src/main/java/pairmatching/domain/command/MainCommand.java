package pairmatching.domain.command;

import java.util.Arrays;

public enum MainCommand {
    MATCHING("1", "페어 매칭"),
    FIND("2", "페어 조회"),
    INIT("3", "페어 초기화"),
    EXIT("Q", "종료");

    private final String command;
    private final String description;

    MainCommand(final String command, final String description) {
        this.command = command;
        this.description = description;
    }

    public static MainCommand parseMainCommand(String inputCommand) {
        return Arrays.stream(values())
            .filter(mainCommand -> mainCommand.command.equals(inputCommand))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 기능입니다."));
    }
}