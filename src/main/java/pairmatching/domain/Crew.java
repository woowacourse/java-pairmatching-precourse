package pairmatching.domain;

import java.util.HashMap;

public class Crew {
    private Course course;
    private String name;
    private HashMap<Level, Crew> matchedList = new HashMap<>();

    public Crew(String crewName) {
        name = crewName;
    }

    public void addMatchedPartner(Level level, Crew crew) {
        matchedList.put(level, crew);
    }

    public boolean isMatched(Level level, Crew crew) {
        return matchedList.get(level) == crew;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
