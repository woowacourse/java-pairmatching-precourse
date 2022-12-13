package pairmatching.domain;

import java.util.Arrays;

public enum YesNoCommand {
    YES("네"),
    NO("아니오");

    private static final String YES_NO_COMMAND_ERROR = "[ERROR] 명령어는 네 / 아니오로 입력해 주세요.";

    private final String command;

    YesNoCommand(String command){
        this.command = command;
    }

    public static YesNoCommand fromInput(String input){
        return Arrays.stream(values())
                .filter(command->command.getCommand().equals(input))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(YES_NO_COMMAND_ERROR));
    }

    public String getCommand(){
        return command;
    }
}
