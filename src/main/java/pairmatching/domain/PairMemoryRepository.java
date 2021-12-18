package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairMemoryRepository {
    List<PairMemory> pairMemoryList;

    public PairMemoryRepository() {
        pairMemoryList = new ArrayList<>();
    }

    public PairMemory searchPairMemory(Section section) {
        // TODO : 과정, 레벨, 미션으로 페어를 찾는다.
        return null;
    }

    public void clear() {
        // TODO : 모든 페어를 초기화한다.
        pairMemoryList.clear();
    }

}
