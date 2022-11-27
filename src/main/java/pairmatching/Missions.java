package pairmatching;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        missionMap.get(Level.LEVEL2).add("로또");
        missionMap.get(Level.LEVEL2).add("숫자야구게");

        missionMap.get(Level.LEVEL4).add("성능개선");
        missionMap.get(Level.LEVEL4).add("배포");


    }
}
