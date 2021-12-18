package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Crew {
    private String course;
    private String name;
    private HashMap<String, List<String>> MatcingCrewTable = new HashMap<String, List<String>>() {{
        put("레벨1", new ArrayList<>());
        put("레벨2", new ArrayList<>());
        put("레벨3", new ArrayList<>());
        put("레벨4", new ArrayList<>());
        put("레벨5", new ArrayList<>());
    }};

    Crew(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public boolean hasMatcingCrew(String matchingCrewName, String level) {
        List<String> matchingCrews = MatcingCrewTable.get(level);
        for (String crew : matchingCrews) {
            if (crew.equals(matchingCrewName)) {
                return true;
            }
        }
        return false;
    }

}
