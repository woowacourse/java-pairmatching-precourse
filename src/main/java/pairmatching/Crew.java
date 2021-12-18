package pairmatching;

import java.util.HashMap;
import java.util.ArrayList;

public class Crew {
    private static final int MAX_LEVEL = 5;
    private static final int MIN_LEVEL = 1;
    private String name;
    private HashMap<Integer, ArrayList<Crew>> metCrew;

    public Crew(String name) {
        this.name = name;
        metCrew = new HashMap<Integer, ArrayList<Crew>>();
        for (int i = MIN_LEVEL; i<=MAX_LEVEL; i++) {
            metCrew.put(i, new ArrayList<Crew>());
        }
    }

    public String getName() {
        return this.name;
    }

    public void push(Crew crew, int level) {
        metCrew.get(level).add(crew);
    }

    public void pop(Crew crew, int level) {
        metCrew.get(level).remove(crew);
    }

    public boolean checkCrew(Crew crew, int level) {
        return !metCrew.get(level).contains(crew);
    }
}
