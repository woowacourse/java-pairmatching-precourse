package pairmatching.controller.dto.request;

import pairmatching.domain.constants.Course;
import pairmatching.domain.constants.Level;
import pairmatching.domain.constants.Mission;

public class PairRequest {
    private Course course;
    private Level level;
    private Mission mission;

    public Course course() {
        return course;
    }

    public Level level() {
        return level;
    }

    public Mission mission() {
        return mission;
    }
}
