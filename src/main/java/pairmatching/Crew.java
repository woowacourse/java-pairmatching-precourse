package pairmatching;

import java.util.HashMap;
import java.util.ArrayList;

public class Crew {
    private static final int MAX_LEVEL = 5;
    private static final int MIN_LEVEL = 1;
    private String name;
    private HashMap<Integer, ArrayList<String>> metCrew;

    public Crew(String name) {
        this.name = name;
        for (int i = MIN_LEVEL; i<=MAX_LEVEL; i++) {
            metCrew.put(i, new ArrayList<String>());
        }
    }
}
