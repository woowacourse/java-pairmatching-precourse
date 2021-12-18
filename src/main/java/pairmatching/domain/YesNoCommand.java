package pairmatching.domain;

import java.util.Arrays;
import pairmatching.exception.CommandNotFoundException;

public enum YesNoCommand {

    YES("네"),
    NO("아니오");

    private final String name;

    YesNoCommand(String name) {
        this.name = name;
    }

    public static YesNoCommand getCommand(String name) {
        return Arrays.stream(values())
            .filter(yesNoCommand -> yesNoCommand.name.equals(name))
            .findFirst()
            .orElseThrow(CommandNotFoundException::new);
    }

    public boolean isNo() {
        return this == NO;
    }
}
