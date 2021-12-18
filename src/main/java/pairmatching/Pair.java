package pairmatching;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pair {
    private String crew1;
    private String crew2;
    private String crew3;

    Pair(String crew1, String crew2) {
        this.crew1 = crew1;
        this.crew2 = crew2;
    }

    Pair(String crew1, String crew2, String crew3) {
        this.crew1 = crew1;
        this.crew2 = crew2;
        this.crew3 = crew3;
    }

    public static ArrayList<Pair> makePairList(ArrayList<String> crewList) {
        ArrayList<Pair> pairList = new ArrayList<Pair>();
        for (int i = 0; i < crewList.size(); i += 2) {
            if (i + 1 >= crewList.size()) {
                pairList.set(pairList.size() - 1, new Pair(crewList.get(i - 2), crewList.get(i - 1), crewList.get(i)));
            }
            if (i + 1 < crewList.size()) {
                Pair pair = new Pair(crewList.get(i), crewList.get(i + 1));
                pairList.add(pair);
            }
        }
        return pairList;
    }
}

