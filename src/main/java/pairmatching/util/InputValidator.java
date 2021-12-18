package pairmatching.util;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.LevelAndMission;
import pairmatching.model.Mission;
import pairmatching.repository.LevelAndMissionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private static final String NEW_LINE = "\n";
    private static final String MAIN_SCREEN_INPUT_FORMAT = "[123Q]";
    private static final String INVALID_SCREEN_INPUT = "선택할 수 없는 기능입니다.";
    private static final String CONDITION_REGEX = "[ ,]+";
    private static final int CONDITIONS_SIZE = 3;
    private static final String INVALID_CONDITION_SIZE = "과정, 레벨, 미션 세 가지를 작성해주세요.";
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;
    private static final String INVALID_COURSE_NAME = "존재하지 않는 과정입니다.";
    private static final String INVALID_LEVEL_NAME = "존재하지 않는 레벨입니다.";
    private static final String INVALID_MISSION_NAME = "존재하지 않는 미션입니다.";
    private static final String INVALID_LEVEL_AND_MISSION = "해당 레벨에 존재하는 미션이 아닙니다.";
    private static final String NO_MISSIONS_IN_CURRENT_LEVEL_MESSAGE = "해당 레벨에 존재하는 미션이 없습니다.";

    public static void validateMainScreenInput(String input) {
        if (!input.matches(MAIN_SCREEN_INPUT_FORMAT)) {
            throw new IllegalArgumentException(INVALID_SCREEN_INPUT);
        }
    }

    public static void validateMatchingInput(String input) {
        List<String> conditions = Arrays.asList(input.split(CONDITION_REGEX));
        validateSize(conditions);
        validateCourse(conditions.get(COURSE_INDEX));
        validateLevel(conditions.get(LEVEL_INDEX));
        validateMission(conditions.get(MISSION_INDEX));
        validateLevelAndMissions(conditions.get(LEVEL_INDEX), conditions.get(MISSION_INDEX));
    }

    private static void validateLevelAndMissions(String levelName, String missionName) {
        List<Mission> missions = LevelAndMissionRepository.getMissionsByLevelName(levelName).get().getMissions();
        if (missions.isEmpty()) {
            throw new IllegalArgumentException(NO_MISSIONS_IN_CURRENT_LEVEL_MESSAGE);
        }
        if (missions.stream()
                .map(Mission::getMissionName)
                .noneMatch(name -> name.equals(missionName))) {
            throw new IllegalArgumentException(INVALID_LEVEL_AND_MISSION);
        }
    }

    private static void validateCourse(String courseName) {
        if (Arrays.stream(Course.values())
                .noneMatch(course -> course.getCourseName().equals(courseName))) {
            throw new IllegalArgumentException(INVALID_COURSE_NAME);
        }
    }

    private static void validateLevel(String levelName) {
        if (Arrays.stream(Level.values())
                .noneMatch(level -> level.getLevelName().equals(levelName))) {
            throw new IllegalArgumentException(INVALID_LEVEL_NAME);
        }
    }

    private static void validateMission(String missionName) {
        if (Arrays.stream(Mission.values())
                .noneMatch(mission -> mission.getMissionName().equals(missionName))) {
            throw new IllegalArgumentException(INVALID_MISSION_NAME);
        }
    }

    private static void validateSize(List<String> conditions) {
        if (!(conditions.size() == CONDITIONS_SIZE)) {
            throw new IllegalArgumentException(INVALID_CONDITION_SIZE);
        }
    }
}
