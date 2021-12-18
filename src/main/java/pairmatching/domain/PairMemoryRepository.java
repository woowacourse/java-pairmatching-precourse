package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class PairMemoryRepository {
    List<PairMemory> pairMemoryList;

    public PairMemoryRepository() {
        pairMemoryList = new ArrayList<>();
    }

    public PairMemory searchPairMemory(Section section) {
        // TODO : 과정, 레벨, 미션으로 페어를 찾는다.
        for(PairMemory pairMemory : pairMemoryList) {
            if(pairMemory.getSection().compare(section)) {
                return pairMemory;
            }
        }
        throw new IllegalArgumentException("[ERROR] 검색 결과가 없습니다.");
    }

    public void clear() {
        // TODO : 모든 페어를 초기화한다.
        pairMemoryList.clear();
    }

    public void addPairMemory(PairMemory pairMemory) {
        pairMemoryList.add(pairMemory);
    }

    public void delete(PairMemory pairMemory) {
        pairMemoryList.remove(pairMemory);
    }

    public List<PairMemory> findByCourseAndLevel(Course course, Level level) {
        return pairMemoryList.stream()
            .filter(pairMemory -> pairMemory.getSection().getCourse() == course
                && pairMemory.getSection().getLevel() == level).collect(
            Collectors.toList());
    }

    public void validatePairMemory(PairMemory pairMemory) {
        List<PairMemory> pairMemoryList
            = findByCourseAndLevel(pairMemory.getSection().getCourse(), pairMemory.getSection().getLevel());
        for(PairMemory existPairMemory : pairMemoryList) {
            validatePairs(existPairMemory.getPairs(), pairMemory.getPairs());
        }
    }

    private void validatePairs(List<List<String>> existPairs, List<List<String>> pairs) {
        for(List<String> existPair : existPairs) {
            for(List<String> pair : pairs) {
                validatePair(existPair, pair);
            }
        }
    }

    private void validatePair(List<String> existPair, List<String> pair) {
        System.out.println("compare with " + existPair + " and " + pair);
        if(existPair.containsAll(pair)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 조합입니다.");
        }
    }

}
