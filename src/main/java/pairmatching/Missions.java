package pairmatching;

import java.util.*;

public class Missions {
    private static Map<Level, List<String>> missionMap;

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
        missionMap.get(Level.LEVEL1).add("자동차경주");
        missionMap.get(Level.LEVEL1).add("로또");
        missionMap.get(Level.LEVEL1).add("숫자야구게임");

        missionMap.get(Level.LEVEL2).add("장바구니");
        missionMap.get(Level.LEVEL2).add("결제");
        missionMap.get(Level.LEVEL2).add("지하철노선도");

        missionMap.get(Level.LEVEL4).add("성능개선");
        missionMap.get(Level.LEVEL4).add("배포");
    }
    public List<String> getValue(Level level) {
        return Collections.unmodifiableList(missionMap.get(level));
    }
}
