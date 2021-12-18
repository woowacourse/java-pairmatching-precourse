package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PairProgramming {

    private String course;
    private String level;
    private String mission;

    private static final List<String> LEVEL1MISSION = Arrays.asList("자동차경주", "로또", "숫자야구게임");
    private static final List<String> LEVEL2MISSION = Arrays.asList("장바구니", "결제", "지하철노선도");
    private static final List<String> LEVEL3MISSION = Arrays.asList("성능개선", "배포");

    // 미션, 페어1, 페어2
    private Map<String, Map<String, Set<String>>> crewPairInfo = new LinkedHashMap();
    // 페어1, 페어1의 페어 였던 사람들
    private Map<String, Set<String>> crewPairInfoHistory = new LinkedHashMap();

    public PairProgramming(String targetCourse, String targetLevel, String targetMission, List<String> shuffledCrew) {
        this.course = targetCourse;
        this.level = targetLevel;
        this.mission = targetMission;

        validMission();
        initCrewPairInfo(mission, shuffledCrew);
        createPairInfo(shuffledCrew);

    }

    private void validMission() {
        if (level.equals("1")) {

        }
    }

    private void createPairInfo(List<String> shuffledCrew) {

        int crewSize = shuffledCrew.size();
        createPairInfoBySize(shuffledCrew, crewSize);

    }

    private void createPairInfoBySize(List<String> shuffledCrew, int crewSize) {
        if (crewSize % 2 == 0) {
            // 짝수
            for (int i = 0; i < shuffledCrew.size(); i+=2) {
                String crew1 = shuffledCrew.get(i);
                String crew2 = shuffledCrew.get(i + 1);
                crewPairInfo.get(mission).get(crew1).add(crew2);
                crewPairInfo.get(mission).get(crew2).add(crew1);
                crewPairInfoHistory.get(crew1).add(crew2);
                crewPairInfoHistory.get(crew2).add(crew1);
            }
            return;
        }
        if (crewSize % 2 == 1) {
            // 홀수
            for (int i = 0; i < shuffledCrew.size() - 3; i+=2) {
                String crew1 = shuffledCrew.get(i);
                String crew2 = shuffledCrew.get(i + 1);
                crewPairInfo.get(mission).get(crew1).add(crew2);
                crewPairInfo.get(mission).get(crew2).add(crew1);
                crewPairInfoHistory.get(crew1).add(crew2);
                crewPairInfoHistory.get(crew2).add(crew1);
            }
            int totalCrew = shuffledCrew.size();
            String crew1 = shuffledCrew.get(totalCrew - 3);
            String crew2 = shuffledCrew.get(totalCrew - 2);
            String crew3 = shuffledCrew.get(totalCrew - 1);
            crewPairInfo.get(mission).get(crew1).add(crew2);
            crewPairInfo.get(mission).get(crew1).add(crew3);
            crewPairInfo.get(mission).get(crew2).add(crew1);
            crewPairInfo.get(mission).get(crew2).add(crew3);
            crewPairInfo.get(mission).get(crew3).add(crew1);
            crewPairInfo.get(mission).get(crew3).add(crew2);
            crewPairInfoHistory.get(crew1).add(crew2);
            crewPairInfoHistory.get(crew1).add(crew3);
            crewPairInfoHistory.get(crew2).add(crew1);
            crewPairInfoHistory.get(crew2).add(crew3);
            crewPairInfoHistory.get(crew3).add(crew1);
            crewPairInfoHistory.get(crew3).add(crew2);
        }
    }

    private void initCrewPairInfo(String mission, List<String> shuffledCrew) {
        crewPairInfo.put(mission, new HashMap<>());
        shuffledCrew.forEach(crew -> crewPairInfo.get(mission).put(crew, new HashSet()));
        shuffledCrew.forEach(crew -> crewPairInfoHistory.put(crew, new HashSet()));
    }

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public Map<String, Map<String, Set<String>>> crewPairInfo() {
        return crewPairInfo;
    }
}
