package pairmatching;

import pairmatching.controller.PairMatching;

public class Application {
    public static void main(String[] args) {
        PairMatching pairMatching = new PairMatching();
        start(pairMatching);
    }

    private static void start(PairMatching pairMatching) {
        pairMatching.executeFeature();
    }
}
