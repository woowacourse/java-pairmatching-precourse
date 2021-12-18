package pairmatching;

public class Matching {
    //public boolean matchingEnd = false;
    String action = "";
    String course = "";
    int level = 0;
    String mission = "";

    Matching() {
        OutputView.outputActions();
        this.action = InputView.inputAction();
        Action.checkActionNumber(action);
        OutputView.outputCourse();
        InputView.inputCourseLevelMission();
    }
}
