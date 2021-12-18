package pairmatching.matching.mathcingtitle;

import pairmatching.crew.Course;
import pairmatching.crew.Level;

public class MatchingTitle {

    private Course course;
    private Level level;
    private String mission;

    private MatchingTitle(){}

    public static MatchingTitle fromCourseAndLevelAndMission(Course course, Level level, String mission) {
        MatchingTitle matchingTitle = new MatchingTitle();
        matchingTitle.course = course;
        matchingTitle.level = level;
        matchingTitle.mission = mission;
        return matchingTitle;
    }

    public boolean isSame(Level level, String mission) {
        return this.level.equals(level) && this.mission.equals(mission);
    }
}
