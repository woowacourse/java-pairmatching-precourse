package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Mission {

    private final List<Match> matches;
    private final String name;

    public Mission(List<Match> matches, String name) {
        this.matches = matches;
        this.name = name;
    }

    public static Mission createEmptyMission(String name) {
        return new Mission(new ArrayList<>(), name);
    }

    public boolean equalsName(Mission mission) {
        return this.name.equals(mission.name);
    }
}
