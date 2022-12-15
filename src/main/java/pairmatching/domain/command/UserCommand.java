package pairmatching.domain.command;

public class UserCommand {

    private final Command command;

    public UserCommand(String command) {
        validate(command);
        this.command = Command.valueOf(command);
    }

    private void validate(String command) {
        if (!Command.contains(command)) {
            throw new IllegalArgumentException("[ERROR] 지원하는 기능 명령어가 아닙니다.");
        }
    }

    public boolean isCommandOf(Command command) {
        return this.command.equals(command);
    }
}
