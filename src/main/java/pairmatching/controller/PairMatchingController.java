package pairmatching.controller;

import pairmatching.validation.FunctionSelectValidation;
import pairmatching.view.InputView;

public class PairMatchingController {
    int selectNum;
    public void run(){
        functionSelect();
    }

    private void functionSelect(){
        String number = InputView.inputFunctionSelect();
        try{
            FunctionSelectValidation.isCorrect(number);
            selectNum = Integer.parseInt(number);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            functionSelect();
        }
    }
}
