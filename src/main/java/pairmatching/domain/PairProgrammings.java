package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class PairProgrammings {

    private List<PairProgramming> pairProgrammings = new ArrayList<>();

    public void enrollNewProgram(String targetCourse, String targetLevel, String targetMission, List<String> shuffledCrew) {
        pairProgrammings.add(new PairProgramming(targetCourse, targetLevel, targetMission, shuffledCrew));
    }

    public Map<String, Set<String>> getPairInfo(String targetCourse, String targetLevel, String targetMission) {

        return pairProgrammings.stream()
            .filter(pairProgramming -> Objects.equals(pairProgramming.getCourse(), targetCourse))
            .filter(pairProgramming -> Objects.equals(pairProgramming.getLevel(), targetLevel))
            .map(pairProgramming -> pairProgramming.crewPairInfo())
            .findFirst()
            .get()
            .get(targetMission);
    }
}
