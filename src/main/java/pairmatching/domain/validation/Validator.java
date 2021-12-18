package pairmatching.domain.validation;

public class Validator {
    private final int EMPTY_INPUT = 0;
    private Exception exception;

    public Validator(Exception exception) {
        this.exception = exception;
    }

    private void checkEmptyInput(String input) {

        if (input.trim().length() == EMPTY_INPUT) {
            exception.throwException(ErrorMessage.EMPTY_INPUT);
        }

    }

    private void checkMenuChoice(String menu) {

        if (!menu.matches(Text.REGEX_MENU)) {
            exception.throwException(ErrorMessage.WRONG_CHOICE);
        }

    }

    public void isValidMenuChoice(String menu) {
        checkEmptyInput(menu);
        checkMenuChoice(menu);
    }
}
