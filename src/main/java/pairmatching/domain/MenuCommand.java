package pairmatching.domain;

import java.util.Arrays;

public enum MenuCommand {
    PAIR_MATCHING("1"),
    PAIR_SEARCHING("2"),
    PAIR_INITIALIZE("3"),
    QUIT("Q");

    private static final String MENU_COMMAND_ERROR = "[ERROR] 지원하지 않는 명령어입니다. 다시 입력해 주세요.";

    private final String command;

    MenuCommand(String command){
        this.command = command;
    }

    public static MenuCommand fromInput(String input){
        return Arrays.stream(values())
                .filter(command->command.getCommand().equals(input))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(MENU_COMMAND_ERROR));
    }

    public String getCommand(){
        return command;
    }
}
