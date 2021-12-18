package pairmatching.model;

import java.util.List;

public class Pair {
    List<Crew> crews;
    Course course;
    Level level;
    Mission mission;

    public List<Crew> getCrews() {
        return crews;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
