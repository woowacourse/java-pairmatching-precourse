package pairmatching.vo;

import java.util.Arrays;

public enum MainCommand {
    MATCHING("1", "페어 매칭"),
    FIND("2", "페어 조회"),
    RESET("3", "페어 초기화"),
    QUIT("Q", "종료");

    private final String command;
    private final String description;

    MainCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static MainCommand findByCommand(String command) {
        return Arrays.stream(values())
                .filter(mainCommand -> mainCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1, 2, 3, Q 중 하나가 아닌 커멘드 입력"));
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
