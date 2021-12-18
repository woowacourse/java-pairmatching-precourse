package pairmatching.domain;

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

    public static void validator(String optionNumber) {
        isBlank(optionNumber);
        isOverLength(optionNumber);
        if (isDigit(optionNumber)) {
            isCorrectMenu(optionNumber);
            return;
        }
        isExitChar(optionNumber);
    }

    private static void isOverLength(String optionNumber) {
        if (optionNumber.length() > MENU_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.OVER_LENGTH.print());
        }
    }

    private static void isBlank (String optionNumber) {
        if (optionNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK.print());
        }
    }

    private static void isExitChar(String optionNumber) {
        if(optionNumber.charAt(0) != QUIT_CHAR) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_EXIST_OPTION.print());
        }
    }

    private static boolean isDigit(String optionNumber) {
        if (Character.isDigit(optionNumber.charAt(0))){
            return true;
        }
        return false;
    }

    public static void isCorrectMenu(String optionNumber) {
        if (Integer.parseInt(optionNumber) > MAX_MENU_OPTION_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_EXIST_OPTION.print());
        }
    }
}
