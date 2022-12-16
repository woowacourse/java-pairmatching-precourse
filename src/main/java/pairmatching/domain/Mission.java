package pairmatching.domain;

import java.util.Arrays;

import static pairmatching.domain.Level.*;
import static pairmatching.util.Validator.ERROR_PREFIX;

public enum Mission {

    MISSION1_1(LEVEL1, "자동차게임"), MISSION1_2(LEVEL1, "로또"),MISSION1_3(LEVEL1, "숫자야구게임"),
    MISSION2_1(LEVEL2, "장바구니"), MISSION2_2(LEVEL2, "결제"), MISSION2_3(LEVEL2, "지하철노선도"),
    MISSION4_1(LEVEL4, "성능개선"), MISSION4_2(LEVEL4, "배포");

    private Level level;
    private String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public static Mission checkExistMission(Level inputLevel, String inputName) {
        return Arrays.stream(values())
                .filter(mission -> inputLevel == mission.level)
                .filter(mission -> inputName.equals(mission.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 미션입니다."));
    }
}
