package pairmatching;

import java.util.ArrayList;

public class PairOutput {
    private static final String PAIR_MATCHING_RESULT_INTRO = "페어 매칭 결과입니다.";
    private static final String PAIR_MATCHING_INQUIRE_INTRO = "페어 조회 결과입니다.";

    public static void printPairResult(ArrayList<Pair> pairs) {
        System.out.println(PAIR_MATCHING_RESULT_INTRO);
        for (Pair pair : pairs) {
            System.out.println(pair);
        }
        System.out.println();
    }

    public static void printPairInquireResult(ArrayList<Pair> pairs) {
        System.out.println(PAIR_MATCHING_INQUIRE_INTRO);
        for (Pair pair : pairs) {
            System.out.println(pair);
        }
        System.out.println();
    }

}
