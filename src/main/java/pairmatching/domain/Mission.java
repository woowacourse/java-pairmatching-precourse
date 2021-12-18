package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Mission {

    private final List<Match> matches;
    private final String name;
    private final Course course;

    public Mission(List<Match> matches, String name, Course course) {
        this.matches = matches;
        this.name = name;
        this.course = course;
    }

    public static Mission createEmptyMission(String name, Course course) {
        return new Mission(new ArrayList<>(), name, course);
    }

    public boolean isEqualsMission(Mission mission) {
        return this.course.equals(mission.course) && this.name.equals(mission.name);
    }
}
