package pairmatching.domain;

import java.util.ArrayList;

public class Pair {
    private String course;
    private String level;
    private String mission;
    private ArrayList<String> crews;

    public Pair(String course, String level, String mission, ArrayList<String> crews) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.crews = crews;
    }

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }

    public ArrayList<String> getCrews() {
        return crews;
    }
}
