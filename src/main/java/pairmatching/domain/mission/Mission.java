package pairmatching.domain.mission;

import pairmatching.domain.course.Course;
import pairmatching.domain.level.Level;
import pairmatching.domain.matcher.PairController;
import pairmatching.domain.matcher.Pairs;

public class Mission {
    private Course course;
    private Level level;
    private String name;
    private PairController pairController;

    public Mission( Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public boolean isSameLevel(Mission mission) {
        return this.level.isSameLevel(mission.level);
    }

    public Level getLevel() {
        return level;
    }

}
