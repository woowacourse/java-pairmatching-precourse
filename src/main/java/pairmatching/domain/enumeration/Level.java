package pairmatching.domain.enumeration;

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

    // 추가 기능 구현
}