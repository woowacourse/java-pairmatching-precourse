package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

import java.util.ArrayList;
import java.util.List;

public class ValidationController {
    private static final String ERROR_WRONG_INPUT = "[ERROR] 잘못된 값 입력입니다";
    private static final String ERROR_WRONG_MISSION = "[ERROR] 잘못된 미션 입력입니다.";
    private static final String ERROR_WRONG_LEVEL = "[ERROR] 잘못된 레벨 입력입니다.";
    private static final String ERROR_WRONG_COURSE = "[ERROR] 잘못된 과정 입력입니다.";

    public static void chooseFunctionValidation(String input) {
        if (!isNumValidation(input)) {
            throw new IllegalArgumentException(ERROR_WRONG_INPUT);
        }
    }

    private static boolean isNumValidation(String input) {
        try {
            int num = Integer.parseInt(input);
            if (!(1 <= num && num <= 3)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkSpellQValidation(String input) {
        if (input.equals("Q")) {
            return true;
        }
        return false;
    }

    public static void inputProcessValidation(String inputProcess) {
        String[] checkData = inputProcess.split(", ");
        commaCheck(inputProcess);
        courseCheck(checkData[0]);
        levelCheck(checkData[1]);
        missionCheck(checkData[1], checkData[2]);
    }

    private static void commaCheck(String inputProcess) {
        int count = 0;
        for (int i =0; i<inputProcess.length(); i++){
            if (inputProcess.charAt(i) == ','){
                count += 1;
            }
        }

        if (count != 2){
            throw new IllegalArgumentException(ERROR_WRONG_INPUT);
        }
    }

    private static void missionCheck(String level, String checkMission) {
        Mission mission = new Mission();
        List<String> levelMission = mission.getLevelMission(level);

        if (!levelMission.contains(checkMission)) {
            throw new IllegalArgumentException(ERROR_WRONG_MISSION);
        }
    }

    private static void levelCheck(String level) {
        List<String> levelList = new ArrayList<>();
        levelList.add(Level.LEVEL1.getName());
        levelList.add(Level.LEVEL2.getName());
        levelList.add(Level.LEVEL3.getName());
        levelList.add(Level.LEVEL4.getName());
        levelList.add(Level.LEVEL5.getName());

        if (!levelList.contains(level)) {
            throw new IllegalArgumentException(ERROR_WRONG_LEVEL);
        }
    }

    private static void courseCheck(String course) {
        List<String> courseList = new ArrayList<>();
        courseList.add(Course.BACKEND.getName());
        courseList.add(Course.FRONTEND.getName());

        if (!courseList.contains(course)) {
            throw new IllegalArgumentException(ERROR_WRONG_COURSE);
        }
    }
}
