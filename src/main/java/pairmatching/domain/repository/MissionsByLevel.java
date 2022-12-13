package pairmatching.domain.repository;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MissionsByLevel {
    private static final Map<Level, List<Mission>> missions = new EnumMap<>(Level.class);

    static {
        initializeMissions();
    }

    private static void initializeMissions() {
        missions.put(Level.LEVEL1, Arrays.asList(new Mission("자동차경주"),
                new Mission("로또"), new Mission("숫자야구게임")));
        missions.put(Level.LEVEL2, Arrays.asList(new Mission("장바구니"), new Mission("결제"),
                new Mission("지하철노선도")));
        missions.put(Level.LEVEL3, Arrays.asList((Mission) null));
        missions.put(Level.LEVEL4, Arrays.asList(new Mission("성능개선"), new Mission("배포")));
        missions.put(Level.LEVEL5, Arrays.asList((Mission) null));
    }

    public static boolean isExistingMissionInCorrectLevel(Level level, Mission mission) {
        return missions.get(level).contains(mission);
    }
}
