package pairmatching;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MatchingInfo {
    private List<List<String>> pairList = new ArrayList<>();

    public MatchingInfo() {
    }

    public void match(boolean isBackend) {
        List<String> crewList=CrewFileReader.getCrew(isBackend)
        int crewListSize = crewList.size();
        int pairCount = (crewListSize - 1) / 2;

        shuffle(crewList);

        //match
        //print

        System.out.println("match crewList");
    }

    public void printMatchingInfo() {
        for (List<String> pair : pairList) {
            System.out.println(String.join(" : ", pair));
        }
    }
}
