package pairmatching.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Missions {
    private static Map<Level, List<Mission>> missionMap;

    public Missions() {
        missionMap = new TreeMap<>();
        init();
    }
    private void init() {
        Level.getList().stream()
                .forEach(level -> missionMap.put(level, new ArrayList<>()));

        addInfo();
    }
    private void addInfo() {
        missionMap.get(Level.LEVEL1).add(Mission.CAR_RACE);
        missionMap.get(Level.LEVEL1).add(Mission.LOTTO);
        missionMap.get(Level.LEVEL1).add(Mission.BASEBALL);

        missionMap.get(Level.LEVEL2).add(Mission.BASKET);
        missionMap.get(Level.LEVEL2).add(Mission.PAY);
        missionMap.get(Level.LEVEL2).add(Mission.SUBWAY);

        missionMap.get(Level.LEVEL4).add(Mission.IMPROVEMENT_PERFORMANCE);
        missionMap.get(Level.LEVEL4).add(Mission.DEPLOYMENT);
    }
    public List<String> getValue(Level level) {
        return Collections.unmodifiableList(missionMap.get(level).stream()
                .map(mission -> mission.getName())
                .collect(Collectors.toList()));
    }

    public boolean isExist(String level, String mission) {
        if (missionMap.get(Level.getEnumLevel(level))
                .contains(Mission.getEnumMission(mission))) {
            return true;
        }
        return false;
    }
}
