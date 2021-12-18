package pairmatching;

import java.io.IOException;
import java.util.List;

public class Crew {
    private Course course;
    private String name;
    private List<String> stringList;
    private Level level;

    public Crew(Course course, String name, List<String> stringList, Level level){
        this.course = course;
        this.name = name;
        this.stringList = stringList;
        this.level = level;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public List<String> getStudentList() {
        return stringList;
    }

    public Level getLevel() {
        return level;
    }
}
