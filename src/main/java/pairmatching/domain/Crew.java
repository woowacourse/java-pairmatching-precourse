package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crew {
    private Course course;
    private String name;
    private Map<Level, List<Crew>> alreadyPair = new HashMap<>();

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void printName() {
        System.out.printf(this.name);
    }

    public boolean isEqual(String name) {
        if (this.name.equals(name)) {
            return true;
        }
        return false;
    }

    public boolean checkAlreadyPair(Level level, Crew crew) {
        if (alreadyPair.size() == 0) {
            return false;
        }
        if (alreadyPair.get(level).contains(crew)) {
            throw new IllegalArgumentException("페어가 취소되었습니다");
        }
        return false;
    }

    public void addAlreadyPair(Level level, Crew crew) {
        if (this.alreadyPair.get(level) == null) {
            this.alreadyPair.put(level, new ArrayList<>());
        }
        this.alreadyPair.get(level).add(crew);
    }
}