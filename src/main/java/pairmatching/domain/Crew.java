package pairmatching.domain;

import java.util.HashMap;
import java.util.List;

public class Crew {
    private Course course;
    private String name;
    private HashMap<String, List<String>> MatchingCrewTable = new HashMap<>();

    Crew(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
