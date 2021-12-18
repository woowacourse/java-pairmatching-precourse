package pairmatching.validation;

import pairmatching.view.Message.ErrorMessage;

public class InfoValidation {
    CommonValidaiton commonValidaiton = new CommonValidaiton();
    public void checkInfo(String input){
        commonValidaiton.checkNull(input);
        checkSize(input);
    }

    private void checkSize(String input){
        if(input.split(",").length != 3){
            throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INFO_LENGTH_UNDER_3);
        }
    }

}
