package pairmatching.repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import pairmatching.domain.entity.CourseMission;
import pairmatching.domain.entity.MatchingResult;
import pairmatching.domain.entity.Mission;

public class MatchingResultRepository {

    protected final Map<CourseMission, MatchingResult> store = new LinkedHashMap<>();

    public void save(CourseMission courseMission, MatchingResult matchingResult) {
        store.put(courseMission, matchingResult);
    }

    public Optional<MatchingResult> findBySameObject(CourseMission courseMission) {
        return Optional.ofNullable(store.get(courseMission));
    }

    public Optional<MatchingResult> findByMission(Mission mission) {
        return store.keySet()
                .stream()
                .filter(courseMission -> courseMission.getMission().equals(mission))
                .map(courseMission -> store.get(courseMission))
                .findAny();
    }

    public void deleteAll() {
        store.clear();
    }

}
