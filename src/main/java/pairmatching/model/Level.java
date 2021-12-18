package pairmatching.model;

import java.util.ArrayList;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;
    private ArrayList<String> missions = new ArrayList<>();

    Level(String name) {
        this.name = name;
    }

    public void addMission(String missionName){
        missions.add(missionName);
    }
    public ArrayList<String> getMissions(){
        return missions;
    }
}
