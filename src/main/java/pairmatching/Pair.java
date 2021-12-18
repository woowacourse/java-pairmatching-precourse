package pairmatching;

import java.util.*;

public class Pair {
    private HashSet<String> pair;

    public Pair(String[] nameList) {
        this.pair=new HashSet<>(Arrays.asList(nameList));
    }

    public void printPair(){
        System.out.println(String.join(" : ",pair));
    }
}
