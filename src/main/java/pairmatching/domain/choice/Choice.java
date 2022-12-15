package pairmatching.domain.choice;

import pairmatching.domain.choice.item.Course;
import pairmatching.domain.choice.item.Mission;

public class Choice {

    private final Course course;
    private final Mission mission;

    public Choice(String courseName, String missionName) {
        this.course = Course.valueOfCourse(courseName);
        this.mission = Mission.valueOfMission(missionName);
    }
}
