package pairmatching.util;

import pairmatching.domain.match.Course;
import pairmatching.domain.match.Level;
import pairmatching.domain.match.MatchData;
import pairmatching.domain.match.Mission;

import java.util.Arrays;
import java.util.List;

import static pairmatching.domain.match.Course.*;
import static pairmatching.domain.match.Level.*;
import static pairmatching.domain.match.Mission.*;
import static pairmatching.util.Constants.*;

public class Validator {
    public final static String ERROR_PREFIX = "[ERROR] ";

    public void validateSelectFunctionValue(String func) {
        List<String> functions = Arrays.asList(FUNC_MATCH, FUNC_SHOW, FUNC_RESET, FUNC_QUIT);
        if (!functions.contains(func)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 기능입니다.");
        }
    }

    public MatchData validateMatchDataIsExist(List<String> inputMatchData) {
        validateMatchDataCount(inputMatchData);
        Course course = validateCourseIsExist(inputMatchData.get(0));
        MatchData matchData = validateMissionIsExist(inputMatchData.get(1), inputMatchData.get(2), course);

        return matchData;
    }

    private MatchData validateMissionIsExist(String inputLevel, String inputMission, Course course) {
        Level level = checkExistLevel(inputLevel);
        Mission mission = checkExistMission(level, inputMission);

        return new MatchData(course, mission);
    }

    private Course validateCourseIsExist(String inputCourse) {
        Course course = checkExistCourse(inputCourse);

        return course;
    }

    private static void validateMatchDataCount(List<String> matchData) {
        if (matchData.size() != 3) {
            throw new IllegalArgumentException(ERROR_PREFIX + "과정, 레벨, 문자 중 입력되지 않은 내용이 존재합니다.");
        }
    }
}
