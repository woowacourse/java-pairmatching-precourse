package pairmatching.domain;

import java.util.ArrayList;

public class PairRepository {
    private static final ArrayList<Pair> pairInformation = new ArrayList<>();

    public static ArrayList<Pair> getPairInformation() {
        return pairInformation;
    }

    public static void addPair(Pair pair) {
        pairInformation.add(pair);
    }

    public static void initialization() {
        pairInformation.clear();
    }
}
