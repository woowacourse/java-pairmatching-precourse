package pairmatching.domain;

import static pairmatching.ErrorMessage.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.CAR_RACING, Mission.LOTTO, Mission.NUM_BASEBALL)),
    LEVEL2("레벨2", Arrays.asList(Mission.SHOPPRING_CART, Mission.PAYMENT, Mission.SUBWAY_LINE)),
    LEVEL3("레벨3", Collections.EMPTY_LIST),
    LEVEL4("레벨4", Arrays.asList(Mission.PERFORMANCE_IMPROVEMENT, Mission.DEPLOYMENT)),
    LEVEL5("레벨5", Collections.EMPTY_LIST);

    private String name;
    private List<Mission> missionList;

    Level(String name, List<Mission> missionList) {
        this.name = name;
        this.missionList = missionList;
    }

    public String getName() {
        return name;
    }

    public static Level find(String name) {
        return Arrays.stream(Level.values())
            .filter(level -> level.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(NO_OBJECT_ERROR));
    }

    //레벨, 미션을 입력하면 -> 레벨에서 missionList 꺼내주고, 그 missionList에 mission이 있나 확인. 없으면 NO_OBJECT_ERROR를 내줌. 있으면 해당 미션을 반환.
}
