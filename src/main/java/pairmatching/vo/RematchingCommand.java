package pairmatching.vo;

import java.util.Arrays;

public enum RematchingCommand {
    YES("네"),
    NO("아니오");

    public static final String INVALID_REMATCHING_COMMAND_VALUE = "네, 아니오가 아닌 유효하지 않은 입력";
    private final String command;

    RematchingCommand(String command) {
        this.command = command;
    }

    public static RematchingCommand findByCommand(String command) {
        return Arrays.stream(values())
                .filter(rematchingCommand -> rematchingCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_REMATCHING_COMMAND_VALUE));
    }

    public String getCommand() {
        return command;
    }
}
