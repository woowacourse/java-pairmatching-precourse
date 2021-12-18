package pairmatching.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputConstants {
    public static final String PAIR_MATCHING = "1";
    public static final String PAIR_SEARCHING = "2";
    public static final String PAIR_CLEAR = "3";
    public static final String PAIR_QUIT = "Q";

    public static final List<String> INPUT = Arrays.asList(new String [] {PAIR_MATCHING, PAIR_SEARCHING, PAIR_CLEAR, PAIR_QUIT});

    public static final String REMATCH_YES = "네";
    public static final String REMATCH_NO = "아니오";

    public static final int MAX_RETRY = 3;
}
