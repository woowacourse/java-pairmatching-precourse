package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class PairProgrammings {

    private List<PairProgramming> pairProgrammings = new ArrayList<>();

    public void enrollNewProgram(String targetCourse, String targetLevel, String targetMission, List<String> shuffledCrew) {
        for (PairProgramming pairProgramming : pairProgrammings) {
            if (pairProgramming.getCourse().equals(targetCourse)) {
                System.out.println(pairProgramming.getLevel());
                System.out.println(targetLevel);
                if (pairProgramming.getLevel().equals(targetLevel)) {
                    pairProgramming.addMission(shuffledCrew, targetMission);
                    return;
                }
            }
        }

        pairProgrammings.add(new PairProgramming(targetCourse, targetLevel, targetMission, shuffledCrew));
    }

    public Map<String, Set<String>> getPairInfo(String targetCourse, String targetLevel, String targetMission) {
        Map<String, Set<String>> pairInfos;
        try {
            pairInfos = pairProgrammings.stream()
                .filter(pairProgramming -> Objects.equals(pairProgramming.getCourse(), targetCourse))
                .filter(pairProgramming -> Objects.equals(pairProgramming.getLevel(), targetLevel))
                .map(pairProgramming -> pairProgramming.crewPairInfo())
                .findFirst()
                .get()
                .get(targetMission);
        } catch (Exception exception) {
            throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
        }

        if (Objects.isNull(pairInfos) || pairInfos.keySet().size() == 0) {
            throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
        }
        return pairInfos;
    }
}
