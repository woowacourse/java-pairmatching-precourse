package pairmatching.controller.mainmenu;

import pairmatching.domain.ErrorMessage;

public class MenuValidator {
    public void checkExistingOption(String optionSelected){
        for (Option option : Option.values()) {
            if( option.getOption().equals(optionSelected)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
            "잘못된 입력입니다. 다시 선택해주세요."));
    }
}
