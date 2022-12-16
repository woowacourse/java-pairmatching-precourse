package pairmatching.domain.choice;

import pairmatching.domain.item.Course;
import pairmatching.domain.item.Mission;

public class Choice {

    private final Course course;
    private final Mission mission;

    public Choice(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }
}
