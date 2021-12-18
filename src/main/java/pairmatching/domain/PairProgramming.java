package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class PairProgramming {

    private String course;
    private String level;
    private String mission;
    // 미션, 페어1, 페어2
    private Map<String, Map<String, Set>> crewPairInfo = new LinkedHashMap();
    // 페어1, 페어1의 페어 였던 사람들
    private Map<String, Set> crewPairInfoHistory = new LinkedHashMap();
    private List<String> backEndCrew = Arrays
        .asList("백호", "태웅", "치수", "태섭", "대만", "준호", "대협", "덕규", "태산", "경태", "수겸", "현준", "준섭",
        "한나", "소연", "호열", "대남", "용팔", "구식", "달재");
    private List<String> frontEndCrew = Arrays
        .asList("보노", "시저", "쉐리", "신디", "다비", "덴버", "이브", "제시", "라라", "린다", "리사", "니콜", "로드",
        "윌터", "제키");

    public PairProgramming(String detailedFunction) {
        String[] detailedFunctions = detailedFunction.split(", ");
        String targetCourse = detailedFunctions[0];
        String targetLevel = detailedFunctions[1];
        String targetMission = detailedFunctions[2];
        this.course = targetCourse;
        this.level = targetLevel;
        this.mission = targetMission;

        if (course.equals("백엔드")) {
            initCrewPairInfo(mission);
            createPairInfo();
        }
    }

    private void createPairInfo() {
        List<String> shuffledCrew = Randoms.shuffle(backEndCrew);
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

    private void initCrewPairInfo(String mission) {
        crewPairInfo.put(mission, new HashMap<>());
        backEndCrew.forEach(crew -> crewPairInfo.get(mission).put(crew, new HashSet()));
        backEndCrew.forEach(crew -> crewPairInfoHistory.put(crew, new HashSet()));
    }
}
