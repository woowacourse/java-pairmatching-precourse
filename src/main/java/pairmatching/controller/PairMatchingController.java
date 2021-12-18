package pairmatching.controller;

import pairmatching.model.*;
import pairmatching.validation.FunctionSelectValidation;
import pairmatching.validation.ProcessLevelMissionValidation;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    String selectNum;
    String[] info;
    public void run(){
        init();
        while(true) {
            functionSelect();
            if (selectNum.equals("1")) {
                OutputView.functionInfo();
                pairMatching();
            } else if (selectNum.equals("2")) {
                OutputView.functionInfo();
                pairSearch();
            } else if (selectNum.equals("3")) {
                pairReset();
            } else if (selectNum.equals("Q")) {
                break;
            }
        }
    }

    private void init(){
        CourseLevelInfo.init();
        BackendCrew.createBackendCrewList();;
        FrontendCrew.createFrontendCrewList();
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
            PairMatching.createPairPerson(info[0], info[1], info[2]);
            PairMatchingList.printPairMatching(info[0], info[1], info[2]);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            pairMatching();
        }
    }

    private void pairSearch(){
        String input = InputView.inputCourseLevelMissionSelect();
        try{
            info = ProcessLevelMissionValidation.isValidation(input);
            PairMatchingList.printPairMatching(info[0], info[1], info[2]);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            pairSearch();
        }

    }

    private void pairReset(){
        PairMatchingList.removeList(info[0], info[1], info[2]);
    }

}
