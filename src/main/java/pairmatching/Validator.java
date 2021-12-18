package pairmatching;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public static final int SELECTION_LENGTH = 1;

    public static final List<String> SELECTION_OPTION = Arrays.asList("1", "2", "3", "4", "Q");

    public static final List<String> YES_OR_NO = Arrays.asList("예" , "아니요");

    public static final String REGEX = "";

    private Validator(){};

    static void validateSelection(String selectionInput) {
        if (selectionInput.length() != SELECTION_LENGTH || !SELECTION_OPTION.contains(selectionInput)) {
            throw new IllegalArgumentException("선택값에 대한 기능이 없습니다.");
        }
    }

    static boolean validateYesOrNo(String answer) {
        if (!YES_OR_NO.contains(answer)) {
            throw new IllegalArgumentException("입력한 값이 예 아니오가 아닙니다.");
        }
        if (YES_OR_NO.get(0).equals(answer)) {
            return true;
        }
        return false;
    }


    /**
     * 입력값이 비었는지 검증
     * @param input
     */
    static void validateNotEmpty(String input) {
        if (input.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
