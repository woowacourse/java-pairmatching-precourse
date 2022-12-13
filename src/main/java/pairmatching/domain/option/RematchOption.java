package pairmatching.domain.option;

import java.util.Arrays;
import pairmatching.util.ExceptionMessage;

public enum RematchOption {
    YES("네"), NO("아니오");

    private final String command;

    RematchOption(String command) {
        this.command = command;
    }

    public static RematchOption from(String command) {
        return Arrays.stream(RematchOption.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_REMATCH_OPTION.getMessage()));
    }

    public boolean isNo() {
        return this == NO;
    }
}
