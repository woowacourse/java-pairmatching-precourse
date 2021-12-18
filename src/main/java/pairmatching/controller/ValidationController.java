package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

import java.util.ArrayList;
import java.util.List;

public class ValidationController {
    public static void chooseFunctionValidation(String input) {
        if (!isNumValidation(input)){
            throw new IllegalArgumentException("[ERROR] 잘못된 값 입력입니다");
        }
    }

    private static boolean isNumValidation(String input) {
        try {
            int num = Integer.parseInt(input);
            if (!(1 <= num && num <= 3)){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean checkSpellQValidation(String input) {
        if (input.equals("Q")){
            return true;
        }
        return false;
    }

    public static void inputProcessValidation(String inputProcess) {
        String[] checkData = inputProcess.split(", ");
        courseCheck(checkData[0]);
        levelCheck(checkData[1]);
        missionCheck(checkData[1], checkData[2]);
    }

    private static void missionCheck(String level, String checkMission) {
        Mission mission = new Mission();
        List<String> levelMission = mission.getLevelMission(level);

        if (!levelMission.contains(checkMission)){
            throw new IllegalArgumentException("[ERROR] 잘못된 미션 입력입니다.");
        }
    }

    private static void levelCheck(String level) {
        List<String> levelList = new ArrayList<>();
        levelList.add(Level.LEVEL1.getName());
        levelList.add(Level.LEVEL2.getName());
        levelList.add(Level.LEVEL3.getName());
        levelList.add(Level.LEVEL4.getName());
        levelList.add(Level.LEVEL5.getName());

        if (!levelList.contains(level)){
            throw new IllegalArgumentException("[ERROR] 잘못된 레벨 입력입니다.");
        }
    }

    private static void courseCheck(String course) {
        List<String> courseList = new ArrayList<>();
        courseList.add(Course.BACKEND.getName());
        courseList.add(Course.FRONTEND.getName());

        if (!courseList.contains(course)){
            throw new IllegalArgumentException("[ERROR] 잘못된 과정 입력입니다.");
        }
    }

}
