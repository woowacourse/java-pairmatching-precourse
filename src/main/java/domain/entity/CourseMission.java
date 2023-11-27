package domain.entity;

import java.util.List;

public class CourseMission {
    private final String course;
    private final String level;
    private final String mission;

    public CourseMission(String course, String level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static CourseMission create(List<String> separated) {
        String course = separated.get(0);
        String level = separated.get(1);
        String mission = separated.get(2);

        return new CourseMission(course, level, mission);
    }
}
