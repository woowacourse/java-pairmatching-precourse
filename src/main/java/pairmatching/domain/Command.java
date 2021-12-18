package pairmatching.domain;

import java.util.Arrays;
import pairmatching.exception.CommandNotFoundException;

public enum Command {

    COMMAND_1("페어 매칭", "1"),
    COMMAND_2("페어 조회", "2"),
    COMMAND_3("페어 초기화", "3"),
    COMMAND_Q("종료", "Q");

    private String name;
    private String request;

    Command(String name, String request) {
        this.name = name;
        this.request = request;
    }

    public static Command getCommand(String request) {
        return Arrays.stream(values())
            .filter(command -> command.request.equals(request))
            .findFirst()
            .orElseThrow(CommandNotFoundException::new);
    }
}
