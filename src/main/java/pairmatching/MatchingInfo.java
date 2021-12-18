package pairmatching;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MatchingInfo {
    private List<Pair> pairList = new ArrayList<>();

    public MatchingInfo() {
    }

    public void match(boolean isBackend) {
        List<String> crewList = CrewFileReader.getCrew(isBackend);
        int crewListSize = crewList.size();
        int pairCount = (crewListSize - 1) / 2;

        shuffle(crewList);

        //match
        for (int i = 0; pairCount > 0; pairCount--) {
            String[] nameList={crewList.get(i++),crewList.get(i++)};
            Pair pair=new Pair(nameList);

            pairList.add(pair);
        }

        printMatchingInfo();
    }

    public void view() {
        printMatchingInfo();
    }

    private void printMatchingInfo() {
        for (Pair pair : pairList) {
            pair.printPair();
        }
    }
}
