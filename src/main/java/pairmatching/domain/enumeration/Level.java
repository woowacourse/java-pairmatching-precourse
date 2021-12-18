package pairmatching.domain.enumeration;

import pairmatching.utils.ErrorMessages;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.CAR_RACING, Mission.LOTTO, Mission.NUMBER_BASEBALL)),
    LEVEL2("레벨2", Arrays.asList(Mission.SHOPPING_CART, Mission.PAYMENT, Mission.SUBWAY_PATH)),
    LEVEL3("레벨3", Collections.EMPTY_LIST),
    LEVEL4("레벨4", Arrays.asList(Mission.PERFORMANCE_IMPROVEMENT, Mission.DEPLOYMENT)),
    LEVEL5("레벨5", Collections.EMPTY_LIST);

    private String name;
    private List<Mission> missionList;

    Level(String name, List<Mission> missionList) {
        this.name = name;
        this.missionList = missionList;
    }

    public static Level findLevelByInput(String input) {
        return Arrays.stream(Level.values())
                .filter(levelName -> levelName.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.PREFIX_ERROR + ErrorMessages.ERROR_INVALID_INPUT));
    }

    public static Level findLevelByMission(Mission mission) {
        return Arrays.stream(Level.values())
                .filter(level -> level.hasMission(mission))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.PREFIX_ERROR + ErrorMessages.ERROR_INVALID_INPUT));
    }

    public boolean hasMission(Mission missionType) {
        return missionList.stream()
                .anyMatch(mission -> mission == missionType);
    }

    // 추가 기능 구현
}