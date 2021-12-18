package pairmatching.exception;

public class CommandNotFoundException extends IllegalArgumentException {

    private static final String COMMAND_NOT_FOUND_ERROR_MESSAGE = "[ERROR] 존재하지 않는 커맨드입니다.";

    public CommandNotFoundException() {
        super(COMMAND_NOT_FOUND_ERROR_MESSAGE);
    }
}
