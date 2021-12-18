package pairmatching.validation;

import pairmatching.view.Message.ErrorMessage;

public class MenuValidation {
    CommonValidaiton commonValidaiton = new CommonValidaiton();
    public void checkNull(String input){
        commonValidaiton.checkNull(input);
    }
}
