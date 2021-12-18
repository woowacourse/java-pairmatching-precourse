package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PairListOfLevel {
    Level level;
    List<Pair> pairList;

    public PairListOfLevel(Level level) {
        initialize();
        this.level = level;

    }

    // 이미 쌍이 존재하는지 검사
    public boolean checkNotMatchedYet(Pair pair) {
        for (int crewNumber = 0; crewNumber <= pair.getCrewSize()-2;) {
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
    public void initialize() {
        pairList = new ArrayList<>();
    }

    // 값 추가
    public void addPair(Pair pair) {
        pairList.add(pair);
    }

    // 값 삭제
    public void deletePair(Pair pair) {
        pairList.remove(pair);
    }

    // 값 조사
    public Pair getPair(Course course, Mission mission) {
        List<Pair> pairs = pairList.stream()
                .filter(pair -> pair.course == course && pair.mission == mission)
                .collect(Collectors.toList());

        if (pairs.isEmpty()) return null;
        return pairs.get(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairListOfLevel that = (PairListOfLevel) o;
        return level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }
}
