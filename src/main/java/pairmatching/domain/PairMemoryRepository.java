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
        for(PairMemory pairMemory : pairMemoryList) {
            if(pairMemory.getSection().compare(section)) {
                return pairMemory;
            }
        }
        throw new IllegalArgumentException("[ERROR] 검색 결과가 없습니다.");
    }

    public void clear() {
        pairMemoryList.clear();
    }

    public void addPairMemory(PairMemory pairMemory) {
        try {
            PairMemory found = searchPairMemory(pairMemory.getSection());
            delete(found);
        }catch (IllegalArgumentException e) {

        }finally {
            pairMemoryList.add(pairMemory);
        }
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
        if(existPair.containsAll(pair)) {
            System.out.println("because of : " + existPair + ", " + pair);
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 조합입니다.");
        }
    }

    private void print(List<List<String>> pairs) {
        for(List<String> pair : pairs) {
            System.out.println(pair);
        }
    }

}
