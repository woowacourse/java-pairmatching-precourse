package pairmatching.domain.program;

import pairmatching.domain.program.command.Command;

public class PairMatchingProgram {

    public void executeCommand(String command) {
        validate(command);
    }

    private void validate(String command) {
        if (!Command.contains(command)) {
            throw new IllegalArgumentException("[ERROR] 지원하는 기능 명령어가 아닙니다.");
        }
    }
}
