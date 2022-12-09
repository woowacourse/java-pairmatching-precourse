package pairmatching.domain;

import java.util.HashMap;
import java.util.List;

public class Mission {
    private static final List<String> MISSION_LEVEL1 = List.of("자동차경주", "로또", "숫자야구게임");
    private static final List<String> MISSION_LEVEL2 = List.of("장바구니", "결제", "지하철노선도");
    private static final List<String> MISSION_LEVEL3 = List.of();
    private static final List<String> MISSION_LEVEL4 = List.of("성능 개선", "배포");
    private static final List<String> MISSION_LEVEL5 = List.of();
    private static final List<List<String>> MISSION_NAMES = List.of(MISSION_LEVEL1, MISSION_LEVEL2, MISSION_LEVEL3,
            MISSION_LEVEL4, MISSION_LEVEL5);
    private static final int INDEX_ZERO = 0;
    private static final int MAX_LEVEL = 5;
    private static final String MISSION_ERROR_MESSAGE = "[ERROR] 미션이름을 잘못 입력하셨습니다.";

    private static final HashMap<Level, List<String>> mission = new HashMap<>();

    static{
        int levelIndex = INDEX_ZERO;
        while(levelIndex<MAX_LEVEL){
            mission.put(Level.values()[levelIndex], MISSION_NAMES.get(levelIndex));
            levelIndex++;
        }
    }

    public static void isExistedMission(Level level, String missionName){
        List<String> missionNames = mission.get(level);
        if(!missionNames.contains(missionName)){
            throw new IllegalArgumentException(MISSION_ERROR_MESSAGE);
        }
    }
}
