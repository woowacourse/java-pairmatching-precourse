package pairmatching.model;

import java.util.List;

public class Pair {
    List<Crew> crews;
    Course course;
    Level level;
    Mission mission;

    public Pair(List<Crew> crews, MatchInfo matchInfo) {
        this.crews = crews;
        course = matchInfo.getCourse();
        level = matchInfo.getLevel();
        mission = matchInfo.getMission();
    }

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
