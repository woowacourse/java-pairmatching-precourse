package pairmatching.domain.matchingcondition;


import pairmatching.domain.course.Course;
import pairmatching.domain.course.enums.CourseEnum;
import pairmatching.domain.level.Level;
import pairmatching.domain.level.enums.LevelEnum;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.mission.enums.MissionEnum;

public class MatchingCondition {
    public static final String SPLIT_DELIMITER = ",";
    Course course;
    Level level;
    Mission mission;

    public MatchingCondition(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public MatchingCondition(String rawMatchingCondition) {
        String[] rawMatchingConditions = rawMatchingCondition.split(SPLIT_DELIMITER);
        Course course = new Course(rawMatchingConditions[0]);
    }
}
