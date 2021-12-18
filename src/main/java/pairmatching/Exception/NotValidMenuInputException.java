package pairmatching.Exception;

public class NotValidMenuInputException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";

    public NotValidMenuInputException() {
        super(ERROR_MESSAGE);
    }
}
