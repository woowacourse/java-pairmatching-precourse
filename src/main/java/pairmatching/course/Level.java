package pairmatching.course;

import java.util.ArrayList;
import java.util.List;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;
    private List<String> missionList;
    Level(String name) {
        this.name = name;
    }

    public void setMissionList(List<String> missionList) {
        this.missionList = missionList;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getMissionList() {
        return this.missionList;
    }

    // 추가 기능 구현
    public String toString() {
        String list = String.join(" | ",this.getMissionList());
        return "- "+getName()+": "+list;
    }
}