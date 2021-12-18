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
    }

    public void initCheck() {
        matchObject = new HashMap<>();

    }

    public static void enrollMatchObject(ArrayList<Integer> pivots) {
        // 매칭 오브젝트를 등록함
        // 예를들어 matchObject[(0, 1, 2)] = {3, 4, 1, 2} 처럼
        // 0 means 백엔드크루
        // 1 means 레벨1
        // 2 means 미션2(=로또)
    }



}
