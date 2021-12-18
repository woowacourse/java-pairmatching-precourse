package pairmatching.model;

import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PairMatchingList {
    private static List<PairMatching> pairMatchingList;

    public static void initPairMatchingList(){
        pairMatchingList = new ArrayList<>();
    }
    public static void addList(String course, String level, String mission, List<List<Crew>> pairPerson){
        PairMatching pairMatching = new PairMatching(course, level, mission, pairPerson);
        pairMatchingList.add(pairMatching);
    }

    public static void existList(String course, String level, String mission){

    }

    public static void removeList(){
        pairMatchingList = new ArrayList<>();
    }

    public static void newPairMatching(String course, String level, String mission){

    }

    public static void printPairMatching(String course, String level, String mission){
        for(PairMatching pairMatching : pairMatchingList){
            System.out.println(pairMatching.getCourse());
            System.out.println(pairMatching.getLevel());
            System.out.println(pairMatching.getMission());
            if(pairMatching.getCourse().equals(course) && pairMatching.getLevel().equals(level) && pairMatching.getMission().equals(mission)){
                OutputView.outputMatchingResult(pairMatching);
                break;
            }
        }
    }
}
