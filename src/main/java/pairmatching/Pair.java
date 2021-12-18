package pairmatching;

import java.util.*;

public class Pair {
    private HashSet<String> pair;

    public Pair(String name1, String name2) {
        this.pair.add(name1);
        this.pair.add(name2);
    }

    public Pair(String name1, String name2, String name3) {
        this.pair.add(name1);
        this.pair.add(name2);
        this.pair.add(name3);
    }

    public void printPair(){

    }
}
