package pairmatching.validator;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;

import java.util.Arrays;

public class Validator {
    private static final String[] MENU_LIST = {"1", "2", "3", "Q"};

    public void validateSelectMenu(String menu) {
        if (!Arrays.asList(MENU_LIST).contains(menu)) {
            throw new IllegalArgumentException("선태한 기능은 없는 기능입니다.");
        }
    }

    public String[] validateCountComma(String information) {
        String[] splitInformation = information.split(",");
        if (splitInformation.length != 3) {
            throw new IllegalArgumentException("입력 형식을 확인해주세요. - 입력 값 사이에 콤마(,)로 구분합니다.");
        }
        return splitInformation;
    }

    public Course validateCourse(String courseName) {
        for (Course course : Course.values()) {
            if (course.getName().equals(courseName)) {
                return course;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 과정입니다.");
    }

    public Level validateLevel(String inputLevel) {
        inputLevel = validateExistSpace(inputLevel);
        Level level = validateExistLevel(inputLevel);
        if (level == null) {
            throw new IllegalArgumentException("존재하지 않는 레벨입니다.");
        }
        return level;
    }

    public Mission validateMission(Level level, String inputMission) {
        inputMission = validateExistSpace(inputMission);
        return validateExistMission(level, inputMission);
    }

    public String validateExistSpace(String string) {
        if (string.charAt(0) != ' ') {
            throw new IllegalArgumentException("입력 형식을 확인해주세요. - 입력 값 사이에 공백을 입력해주세요.");
        }
        return string.substring(1);
    }

    public Level validateExistLevel(String inputLevel) {
        for (Level level : Level.values()) {
            if (level.getName().equals(inputLevel)) {
                return level;
            }
        }
        return null;
    }

    public Mission validateExistMission(Level level, String missionName) {
        Mission mission = level.findMissionByName(missionName);
        if (mission == null) {
            throw new IllegalArgumentException("존재하지 않는 미션입니다.");
        }
        return mission;
    }

    public boolean validateExistPairList(Course course, Mission mission) {
        if (mission.getPairList(course) == null) {
            throw new IllegalArgumentException("매칭 이력이없습니다.");
        }
        return true;
    }
}
