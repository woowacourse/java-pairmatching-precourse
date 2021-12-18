package pairmatching.model;

import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PairMatchingList {
    private static List<PairMatching> pairMatchingList = new ArrayList<>();

    public static void addList(PairMatching pairMatching){
        pairMatchingList.add(pairMatching);
    }

    public static void existList(String course, String level, String mission){

    }

    public static void removeList(String course, String level, String mission){
        for(PairMatching pairMatching : pairMatchingList){
            if(pairMatching.getCourse() == course && pairMatching.getLevel() == level && pairMatching.getMission() == mission){
                pairMatchingList.remove(pairMatching);
                break;
            }
        }
    }

    public static void newPairMatching(String course, String level, String mission){

    }
    public static void printPairMatching(String course, String level, String mission){
        for(PairMatching pairMatching : pairMatchingList){
            if(pairMatching.getCourse() == course && pairMatching.getLevel() == level && pairMatching.getMission() == mission){
                OutputView.outputMatchingResult(pairMatching);
                break;
            }
        }
    }
}
