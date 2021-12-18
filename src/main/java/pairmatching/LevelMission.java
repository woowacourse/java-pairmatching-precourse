package pairmatching;

import pairmatching.missionName.MissionName;

import java.util.*;

public class LevelMission {

    public static final List<MissionName> level1MissionList = Arrays.asList(
            MissionName.RACING,
            MissionName.LOTTO,
            MissionName.BASEBALL
    );

    public static final List<MissionName> level2MissionList = Arrays.asList(
            MissionName.SHOPPING_BAG,
            MissionName.PAY,
            MissionName.METRO
    );

    public static final List<MissionName> level3MissionList = new ArrayList<>();

    public static final List<MissionName> level4MissionList = Arrays.asList(
            MissionName.IMPROVE_PERFORMANCE,
            MissionName.DEPLOY
    );

    public static final List<MissionName> level5MissionList = new ArrayList<>();

    public static final Map<Level, List<MissionName>> levelMissionMap = new HashMap<Level, List<MissionName>>() {{
        put(Level.LEVEL1, level1MissionList);
        put(Level.LEVEL2, level2MissionList);
        put(Level.LEVEL3, level3MissionList);
        put(Level.LEVEL4, level4MissionList);
        put(Level.LEVEL5, level5MissionList);
    }};

}
