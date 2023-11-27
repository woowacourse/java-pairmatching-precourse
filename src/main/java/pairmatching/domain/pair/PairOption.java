package pairmatching.domain.pair;

import java.util.Objects;
import java.util.regex.Pattern;
import pairmatching.domain.option.Course;
import pairmatching.domain.option.Level;
import pairmatching.domain.option.Mission;

public class PairOption {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairOption(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static PairOption createByString(String value) {
        validateRegex(value);
        String[] split = value.split(", ");
        Course course = Course.findByName(split[0]);
        Level level = Level.findByName(split[1]);
        Mission mission = Mission.findByName(split[2]);
        return new PairOption(course, level, mission);
    }

    private static void validateRegex(String value) {
        String regexPattern = "^[가-힣]+,\\s[가-힣]+\\d,\\s[가-힣]+$";

        // 정규표현식 검사
        boolean isMatch = Pattern.matches(regexPattern, value);

        if (!isMatch) {
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
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
