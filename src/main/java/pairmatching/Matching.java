package pairmatching;

import java.util.ArrayList;

public class Matching {
    public boolean matchingEnd = false;
    String action = "";
    String course = "";
    String level = "";
    String mission = "";

    Matching() {
        OutputView.outputActions();
        this.action = InputView.inputAction();
        matchingEnd = checkActionNumber(action);
    }

    public boolean checkActionNumber(String actionNumber) {
        if (actionNumber.equals("1")) {
            OutputView.outputCourse();
            ArrayList<String> arrayList= Utils.splitString(InputView.inputCourseLevelMission());
            this.course = arrayList.get(0).trim();
            this.level = arrayList.get(1).trim();
            this.mission = arrayList.get(2).trim();
            ArrayList<String> crewList = new ArrayList<String>();
            if (course.equals("백엔드")) {
                crewList = (ArrayList)InputView.inputCrew("backend");
            }
            if (course.equals("프론트엔드")) {
                crewList = (ArrayList)InputView.inputCrew("frontend");
            }
            Utils.shuffleCrewList(crewList);
        }
        if (actionNumber.equals("2")) {
            OutputView.outputCourse();
            ArrayList<String> arrayList= Utils.splitString(InputView.inputCourseLevelMission());
            this.course = arrayList.get(0).trim();
            this.level = arrayList.get(1).trim();
            this.mission = arrayList.get(2).trim();
        }
        if (actionNumber.equals("3")) {

        }
        if (actionNumber.equals("Q")) {
            return true;
        }
        return false;
    }
}
