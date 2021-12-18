package pairmatching.controller;

import pairmatching.model.CourseLevelInfo;
import pairmatching.validation.FunctionSelectValidation;
import pairmatching.validation.ProcessLevelMissionValidation;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    String selectNum;
    String[] info;
    public void run(){
        CourseLevelInfo.init();
        while(true) {
            functionSelect();
            if (selectNum.equals("1")) {
                OutputView.functionInfo();
                pairMatching();
            } else if (selectNum.equals("2")) {
                pairSearch();
            } else if (selectNum.equals("3")) {
                pairReset();
            } else if (selectNum.equals("Q")) {
                break;
            }
        }
    }

    private void functionSelect(){
        String number = InputView.inputFunctionSelect();
        try{
            FunctionSelectValidation.isCorrect(number);
            selectNum = number;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            functionSelect();
        }
    }

    private void pairMatching(){
        String input = InputView.inputCourseLevelMissionSelect();
        try{
            info = ProcessLevelMissionValidation.isValidation(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            pairMatching();
        }
    }

    private void pairSearch(){

    }

    private void pairReset(){

    }

}
