package pairmatching.domain.option;

import java.util.Arrays;
import pairmatching.util.ExceptionMessage;

public enum MainOption {

    PAIR_MATCHING("1"),
    PAIR_SEARCHING("2"),
    PAIR_INITIALIZING("3"),
    APPLICATION_EXIT("Q");

    private String command;

    MainOption(String command) {
        this.command = command;
    }

    public static MainOption from(String command) {
        return Arrays.stream(MainOption.values())
                .filter(option -> option.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_MAIN_OPTION.getMessage()));
    }
    public boolean isPlayable() {
        return this != APPLICATION_EXIT;
    }
}