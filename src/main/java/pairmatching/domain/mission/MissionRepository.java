package pairmatching.domain.mission;

import java.util.*;
import java.util.stream.Collectors;

import pairmatching.domain.Level;

public class MissionRepository {
    private Map<String, Mission> missions = new HashMap<>();

    public void createMissions() {
        missions.put("자동차경주", new Mission(Level.LEVEL1, "자동차경주"));
        missions.put("로또", new Mission(Level.LEVEL1, "로또"));
        missions.put("숫자야구게임", new Mission(Level.LEVEL1, "숫자야구게임"));
        missions.put("장바구니", new Mission(Level.LEVEL2, "장바구니"));
        missions.put("결제", new Mission(Level.LEVEL2, "결제"));
        missions.put("지하철노선도", new Mission(Level.LEVEL2, "지하철노선도"));
        missions.put("성능개선", new Mission(Level.LEVEL4, "성능개선"));
        missions.put("배포", new Mission(Level.LEVEL4, "배포"));
    }

    public List<String> findAllMissionNames() {
        return missions.values().stream().map(Mission::getName).collect(Collectors.toList());
    }

    public Map<Level, List<String>> findMissionNamesByLevel() {
        Map<Level, List<String>> missionNamesByLevel = new HashMap<>();
        for (Level level : Level.values()) {
            missionNamesByLevel.put(level, new ArrayList<>());
        }
        for (Mission mission : missions.values()) {
            missionNamesByLevel.get(mission.getLevel()).add(mission.getName());
        }
        return missionNamesByLevel;
    }

    public List<String> findMissionNamesByLevel(Level level) {
        return findMissionNamesByLevel().get(level);
    }
}
