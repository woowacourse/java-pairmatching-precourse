package pairmatching;

import java.util.*;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;
    private List<Mission> missionList=new List<>;

    Level(String name) {
        this.name = name;
    }

    public void addMission(Mission mission){
        this.missionList.add(mission);
    }

    public void printLevel(){
        System.out.print("  - "+name+": ");

        if(missionList.size()>0){
            missionList.get(0).printMission();
            for(Mission m:missionList){
                System.out.print(" | ");
                m.printMission();
            }
        }

        System.out.println();
    }
}
