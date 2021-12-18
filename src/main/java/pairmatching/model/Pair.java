package pairmatching.model;

import java.util.ArrayList;

public class Pair {
    private ArrayList<String> pair = new ArrayList<>();

    public Pair(String name1, String  name2){
        pair.add(name1);
        pair.add(name2);
    }
    public void addPair(String crew){
        pair.add(crew);
    }

    public ArrayList<String> getPair(){
        return pair;
    }
}
