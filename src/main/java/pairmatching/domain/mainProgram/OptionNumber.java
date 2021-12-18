package pairmatching.domain.mainProgram;

import pairmatching.constant.ErrorMessage;

public class OptionNumber {
    final static char QUIT_CHAR = 'Q';
    final static int MAX_MENU_OPTION_NUMBER = 3;
    final static int MENU_LENGTH = 1;

    private String optionNumber;

    public OptionNumber(String optionNumber) {
        validator(optionNumber);
        this.optionNumber = optionNumber;
    }

    public String getOptionNumber() {
        return optionNumber;
    }

    private void validator(String optionNumber) {
        isBlank(optionNumber);
        isOverLength(optionNumber);
        if (isDigit(optionNumber)) {
            isCorrectMenu(optionNumber);
            return;
        }
        isExitChar(optionNumber);
    }

    private void isOverLength(String optionNumber) {
        if (optionNumber.length() > MENU_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.OVER_LENGTH.print());
        }
    }

    private void isBlank(String optionNumber) {
        if (optionNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK.print());
        }
    }

    private void isExitChar(String optionNumber) {
        if (optionNumber.charAt(0) != QUIT_CHAR) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_OPTION.print());
        }
    }

    private static boolean isDigit(String optionNumber) {
        if (Character.isDigit(optionNumber.charAt(0))) {
            return true;
        }
        return false;
    }

    public void isCorrectMenu(String optionNumber) {
        if (Integer.parseInt(optionNumber) > MAX_MENU_OPTION_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_OPTION.print());
        }
    }
}
