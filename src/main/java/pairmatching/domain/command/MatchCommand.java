package pairmatching.domain.command;

import java.util.Arrays;

public enum MatchCommand {
    YES("네"),
    NO("아니오");

    private final String command;

    MatchCommand(final String command) {
        this.command = command;
    }

    public static MatchCommand parseMatchCommand(String inputCommand) {
        return Arrays.stream(values())
            .filter(matchCommand -> matchCommand.command.equals(inputCommand))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 입력입니다."));
    }
}