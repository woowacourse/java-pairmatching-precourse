package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class UserRequest {

    private final Course course;
    private final Level level;
    private final String missionName;

    public UserRequest(Course course, Level level, String missionName) {
        this.course = course;
        this.level = level;
        this.missionName = missionName;
    }
}
