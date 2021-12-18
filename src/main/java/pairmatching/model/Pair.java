package pairmatching.model;

import java.util.ArrayList;

public class Pair {
    private ArrayList<String> pair = new ArrayList<>();
//
//    public Pair(String name1, String  name2){
//        pair.add
//    }
    public void addPair(String crew){
        pair.add(crew);
    }

    public ArrayList<String> getPair(){
        return pair;
    }
    public int getPairLength(){
        return pair.size();
    }
    public void clearPair(){
        pair.clear();;
    }
    
    public void printPair(){
        System.out.println(String.join(":", pair));
    }
}
