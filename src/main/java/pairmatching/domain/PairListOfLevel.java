package pairmatching.domain;

import java.util.List;

public class PairListOfLevel {
    Level level;
    List<Pair> pairList;

    public PairListOfLevel(Level level) {
        this.level = level;
    }

    // 이미 쌍이 존재하는지 검사
    public boolean checkNotMatchedYet(Pair pair) {
        for (int crewNumber = 0; crewNumber < pair.getCrewSize();) {
            if (!checkNotMatchedYetUsingNames(pair.crewNameByNumber(crewNumber), pair.crewNameByNumber(crewNumber + 1))) return false;
            crewNumber = crewNumber + 2;
        }
        return true;
    }

    private boolean checkNotMatchedYetUsingNames(String firstCrewName, String secondCrewName) {
        for(Pair pair: pairList) {
            if (!pair.validateMatchable(firstCrewName, secondCrewName)) return false;
        }
        return true;
    }
    // 값 초기화
    // 과정 삭제
    // 과정 조사


}
