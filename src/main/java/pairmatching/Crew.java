package pairmatching;

import java.io.IOException;
import java.util.List;


public class Crew {
    private Course course;
    private String name;
    private List<String> studentList;
    private Level level;


    public Crew(Course course, String name, List<String> studentList, Level level){
        this.course = course;
        this.name = name;
        this.studentList = studentList;
        this.level = level;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public List<String> getStudentList() {
        return studentList;
    }

    public Level getLevel() {
        return level;
    }

    public void setStudentList(List<String> studentList) {
        this.studentList = studentList;
    }
}
