package pairmatching.validation;

import pairmatching.view.Message.ErrorMessage;

public class InfoValidation {
    public void checkInfo(String input){
        checkNull(input);
        checkSize(input);
    }

    private void checkSize(String input){
        if(input.split(",").length != 3){
            throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INFO_LENGTH_UNDER_3);
        }
    }

    private void checkNull(String input){
        if(input == null){
            throw new IllegalArgumentException(ErrorMessage.ERROR +  ErrorMessage.NULL_INPUT);
        }
    }

}
