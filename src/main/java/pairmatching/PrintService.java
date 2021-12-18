package pairmatching;

import java.util.ArrayList;

import static pairmatching.Message.*;

public class PrintService {
    private LevelService levelService = new LevelService();

    public void printWithMessage(String message) {
        System.out.println(message);
    }

    public void printCourse() {
        String result = DIVIDE_LINE + "\n과정: ";
        for (Course course : Course.values()) {
            result += course.getName() + " | ";
        }
        System.out.println(result.substring(0, result.length() - 2));
    }

    public void printMission() {
        ArrayList<String> levelList = levelService.getLevelList();
        ArrayList<String>[] missionList = levelService.getMissionList();

        String result = "미션: \n";
        for (int i = 0; i < 5; i++) {
            result += "  - " + levelList.get(i) + ": ";
            for (int j = 0; j < missionList[i].size(); j++) {
                result += missionList[i].get(j) + " | ";
            }
            result.substring(0, result.length() - 2);
            result += "\n";
        }
        result += DIVIDE_LINE;
        System.out.println(result);
    }

}
