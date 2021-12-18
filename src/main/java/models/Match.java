package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Match {
    private int course;
    private int level;
    private int mission;
    private Pair pairs;
    public static HashMap<ArrayList<Integer>, ArrayList<Integer>> matchObject;

    public Match(int course, int level, int mission, Pair pairs) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairs = pairs;
        this.matchObject[course][level][mission] = 1;
    }

    public void initCheck() {
        matchObject = new HashMap<>();

    }




}
