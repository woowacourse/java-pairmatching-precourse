package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Crew {
    private String course;
    private String name;
    private Map<Level, ArrayList<Crew>> alreadyPair = new HashMap<>();

    public Crew(String name, String course) {
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
        if (!alreadyPair.containsKey(level)) {
            this.alreadyPair.put(level, new ArrayList<Crew>());
        }
        this.alreadyPair.get(level).add(crew);
    }
}
