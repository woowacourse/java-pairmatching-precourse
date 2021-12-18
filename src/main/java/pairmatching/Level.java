package pairmatching;

import java.util.*;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;
    private List<String> missionList=new ArrayList<>();

    Level(String name) {
        this.name = name;
    }

    public void addMission(String missionName){
        this.missionList.add(missionName);
    }

    public void printLevel(){
        System.out.print("  - "+name+": ");
        ArrayList<String> missionList=new ArrayList<>();
        System.out.println(String.join(" | ",missionList));
    }
}
