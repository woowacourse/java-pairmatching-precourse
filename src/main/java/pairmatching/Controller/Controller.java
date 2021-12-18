package pairmatching.Controller;

import pairmatching.domain.PairLists;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {

    public static void start() {
        PairLists pairlists = new PairLists();
        getFunction();
    }

    public static void getFunction() {
        String functionIndex = InputView.requestFunctionIndex();
        if(functionIndex.equals("1")) {
            matchPair();
            return ;
        }if(functionIndex.equals("2")) {
            lookupPair();
            return ;
        }if(functionIndex.equals("3")) {
            resetPair();
            return ;
        }
        return;
    }

    public static void matchPair() {
        OutputView.printCourseAndMissionList();
        InputView.requestCourseLevelMission();
        getFunction();
    }

    public static void lookupPair() {
        OutputView.printCourseAndMissionList();
        getFunction();
    }

    public static void resetPair() {
        OutputView.printReset();
        getFunction();
    }
}
