package pairmatching;

import java.util.ArrayList;

public class Crew {
    private Course course;
    private Level level;
    private String name;
    private ArrayList<String> meet = new ArrayList<>();


    public Crew(Course course, Level level, String name) {
        this.course = course;
        this.level = level;
        this.name = name;
    }

    public void addMeetList(String name){
        this.meet.add(name);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getMeet() {
        return meet;
    }
}
