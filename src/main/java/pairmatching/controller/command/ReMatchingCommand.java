package pairmatching.controller.command;

import java.util.Arrays;

public enum ReMatchingCommand {
    RE_MATCHING("네"),
    NON_RE_MATCHING("아니오");

    private static final String ERROR_MESSAGE = "[ERROR] %s는 재매칭 명령어가 아닙니다.\n";
    private final String command;

    ReMatchingCommand(String command) {
        this.command = command;
    }

    public static ReMatchingCommand valueOfReMatchingCommand(String inputCommand) {
        return Arrays.stream(values())
                .filter(value -> inputCommand.equals(value.getCommand()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, inputCommand)));
    }

    public String getCommand() {
        return command;
    }

    public boolean isCommandOf(ReMatchingCommand command) {
        return this.command.equals(command.getCommand());
    }
}