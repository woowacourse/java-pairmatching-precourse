package pairmatching.vo;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;

public class PairMatchingInfo {
    private final Course course;
    private final Mission mission;

    public PairMatchingInfo(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return mission.getLevel();
    }
}
