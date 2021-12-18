package pairmatching;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MatchingInfo {
    private List<Pair> pairList = new ArrayList<>();

    public MatchingInfo() {
    }

    public void match(boolean isBackend) {
        List<String> crewList = CrewFileReader.getCrew(isBackend);
        matchCrewRandomly(crewList);
        printMatchingInfo();
    }

    public void view() {
        printMatchingInfo();
    }

    private void matchCrewRandomly(List<String> crewList){
        int crewListSize = crewList.size();
        shuffle(crewList);

        for (int i = 0; i < crewListSize; ) {
            String[] nameList = {crewList.get(i++), crewList.get(i++)};
            if (i == crewListSize - 3) {
                String[] triplenameList = {crewList.get(i++), crewList.get(i++), crewList.get(i++)};

                Pair pair = new Pair(triplenameList);
                pairList.add(pair);
                return;
            }

            Pair pair = new Pair(nameList);
            pairList.add(pair);
        }
    }

    private void printMatchingInfo() {
        System.out.println("\n페어 매칭 결과입니다.");
        for (Pair pair : pairList) {
            pair.printPair();
        }
    }
}
