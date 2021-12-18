package pairmatching.domain;

import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class Section {
    private Course course;
    private Level level;
    private String misson;

    public Section(Course course, Level level, String misson) {
        this.course = course;
        this.level = level;
        this.misson = misson;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public String getMisson() {
        return misson;
    }

    public boolean compare(Section section) {
        return this.course == section.getCourse()
            && this.level == section.getLevel()
            && this.misson.equals(section.getMisson());
    }
}
