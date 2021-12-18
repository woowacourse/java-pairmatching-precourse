package pairmatching.validation;

import pairmatching.domain.InputDTO;

public class InputValidation {
    public static void isValidInput(InputDTO input) {
        if (input.getLevel() == null || input.getCourse() == null || input.getMission() == null) {
            throw new IllegalArgumentException("존재하는 과정, 레벨, 미션을 입력해주세요.");
        }
    }
}
