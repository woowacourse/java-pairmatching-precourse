package pairmatching.domain;

import java.util.ArrayList;

public class Mission {
    private Level level;
    private String name;
    ArrayList<String> pair;

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
        pair = new ArrayList<>();
    }
}
