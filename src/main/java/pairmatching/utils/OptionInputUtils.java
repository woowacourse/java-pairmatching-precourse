package pairmatching.utils;

import static pairmatching.constants.ExceptionMessages.*;
import static pairmatching.constants.SystemConstants.*;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;

public class OptionInputUtils {

    public static boolean isValidOptions(String optionInput) {
        try {
            isValidOptionsInputFormat(optionInput);
            String[] optionInfos = optionInput.split(OPTION_SEPARATOR);
            isValidCourseInput(optionInfos[0]);
            isValidLevelInput(optionInfos[1]);
            isValidMissionInput(optionInfos[2]);
            return true;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void isValidOptionsInputFormat(String optionInput) {
        if (optionInput.split(OPTION_SEPARATOR).length != 3) {
            throw new IllegalArgumentException(INVALID_FORMAT_EXCEPTION);
        }
    }

    public static void isValidCourseInput(String optionInput) {
        Course course = OptionInputUtils.courseNameToDomain(optionInput);
        if (course == null) {
            throw new IllegalArgumentException(NO_COURSE_EXCEPTION);
        }
    }

    public static void isValidLevelInput(String optionInput) {
        Level level = OptionInputUtils.levelNameToDomain(optionInput);
        if (level == null) {
            throw new IllegalArgumentException(NO_LEVEL_EXCEPTION);
        }
    }

    public static void isValidMissionInput(String optionInput) {
        Mission mission = MissionRepository.getMissionByName(optionInput);
        if (mission == null) {
            throw new IllegalArgumentException(NO_MISSION_EXCEPTION);
        }
    }

    public static Course courseNameToDomain(String name) {
        for (Course course : Course.values()) {
            if (!course.getName().equals(name)) continue;
            return course;
        }
        return null;
    }

    public static Level levelNameToDomain(String name) {
        for (Level level : Level.values()) {
            if (!level.getName().equals(name)) continue;
            return level;
        }
        return null;
    }
}
