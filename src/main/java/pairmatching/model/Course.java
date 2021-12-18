package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;
    private List<Crew> crewList = new ArrayList<>();
    private List<String> stringCrewList = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addCrew(Crew crew) {
        crewList.add(crew);
    }

    public void addStringCrew(String name) {
        stringCrewList.add(name);
    }

    public List<String> getStringCrewList() {
        return stringCrewList;
    }

}
