package pairmatching.validation;

import pairmatching.view.Message.ErrorMessage;

public class MenuValidation {
    public void checkNull(String input){
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR +  ErrorMessage.NULL_INPUT);
        }
    }
}
