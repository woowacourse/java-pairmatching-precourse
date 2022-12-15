package pairmatching.domain.command;

import java.util.Arrays;

public enum Command {
    MATCHING("1"),
    CHECKING("2"),
    RESETTING("3"),
    QUITTING("Q");

    private final String key;

    Command(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static Command valueOfCommand(String key) {
        return Arrays.stream(values())
                .filter(value -> key.equals(value.getKey()))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 지원하는 명령어가 아닙니다."));
    }

    public static boolean contains(String command) {
        return Arrays.stream(values())
                .anyMatch(value -> command.equals(value.getKey()));
    }
}
