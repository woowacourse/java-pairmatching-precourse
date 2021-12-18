package pairmatching.course;

import java.util.ArrayList;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;
    private ArrayList<Level> levelList;

    Course(String name) {
        this.name = name;
        this.levelList = new ArrayList<>();
        levelList.add(Level.LEVEL1);
        levelList.add(Level.LEVEL2);
        levelList.add(Level.LEVEL3);
        levelList.add(Level.LEVEL4);
        levelList.add(Level.LEVEL5);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Level> getLevelList() {
        return levelList;
    }
}
