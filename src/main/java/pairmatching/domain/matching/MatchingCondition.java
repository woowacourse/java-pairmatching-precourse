package pairmatching.domain.matching;

import java.util.Objects;

import pairmatching.domain.course.Course;
import pairmatching.domain.course.enums.CourseEnum;
import pairmatching.domain.level.Level;
import pairmatching.domain.mission.Mission;

public class MatchingCondition {
    public static final String SPLIT_DELIMITER = ",";
    public static final int COURSE_INDEX = 0;
    public static final int LEVEL_INDEX = 1;
    public static final int MISSION_INDEX = 2;

    private Course course;
    private Level level;
    private Mission mission;

    public MatchingCondition(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public MatchingCondition(String rawMatchingCondition) throws IllegalArgumentException {
        String[] rawMatchingConditions = rawMatchingCondition.split(SPLIT_DELIMITER);
        this.course = new Course(rawMatchingConditions[COURSE_INDEX]);
        this.level = new Level(rawMatchingConditions[LEVEL_INDEX].trim());
        this.mission = new Mission(rawMatchingConditions[MISSION_INDEX].trim());
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MatchingCondition that = (MatchingCondition)o;
        return Objects.equals(course, that.course) && Objects.equals(level, that.level)
            && Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
