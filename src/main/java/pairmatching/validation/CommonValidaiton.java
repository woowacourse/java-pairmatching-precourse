package pairmatching.validation;

import pairmatching.view.Message.ErrorMessage;

public class CommonValidaiton {
    public void checkNull(String input){
        if(input == null){
            throw new IllegalArgumentException(ErrorMessage.ERROR +  ErrorMessage.NULL_INPUT);
        }
    }
}
