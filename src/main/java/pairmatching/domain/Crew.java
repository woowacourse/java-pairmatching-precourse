package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Crew {
    private Course course;
    private String name;
    private HashMap<Level, List<Crew>> partnerHistory = new HashMap<>();

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;

        for (Level level : Level.values()) {
            partnerHistory.put(level, new ArrayList<>());
        }
    }

    public void addPartnerHistory(Level level, Crew partner) {
        partnerHistory.get(level).add(partner);
    }
}
