package pairmatching.domain.pair;

import java.util.Objects;
import java.util.regex.Pattern;
import pairmatching.domain.option.Course;
import pairmatching.domain.option.Level;
import pairmatching.domain.option.Mission;
import pairmatching.message.ExceptionMessage;

public class PairOption {
    public static final int COURSE_INDEX = 0;
    public static final int LEVEL_INDEX = 1;
    public static final int MISSION_INDEX = 2;
    public static final String OPTION_DELIMITER = ", ";

    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairOption(Course course, Level level, Mission mission) {
        validateMatch(level, mission);
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    private void validateMatch(Level level, Mission mission) {
        if (!mission.getLevel().equals(level)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    public static PairOption createByString(String value) {
        validateRegex(value);
        String[] split = value.split(OPTION_DELIMITER);
        Course course = Course.findByName(split[COURSE_INDEX]);
        Level level = Level.findByName(split[LEVEL_INDEX]);
        Mission mission = Mission.findByName(split[MISSION_INDEX]);
        return new PairOption(course, level, mission);
    }

    private static void validateRegex(String value) {
        String regexPattern = "^[가-힣]+,\\s[가-힣]+\\d,\\s[가-힣]+$";

        // 정규표현식 검사
        boolean isMatch = Pattern.matches(regexPattern, value);

        if (!isMatch) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT);
        }
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PairOption that = (PairOption) o;
        return course == that.course && level == that.level && mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }

    public Level getLevel() {
        return level;
    }
}
