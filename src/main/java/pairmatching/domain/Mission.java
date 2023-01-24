package pairmatching.domain;

import java.util.Arrays;
import java.util.Optional;

import static pairmatching.utils.ExceptionMessage.ERROR_MISSION_NOT_EXIST;

public enum Mission {
    CAR_RACE("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    BASKET("장바구니"),
    PAY("결제"),
    SUBWAY("지하철노선도"),
    IMPROVEMENT_PERFORMANCE("성능개선"),
    DEPLOYMENT("배포");

    private String name;

    Mission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Mission getEnumMission(String name) {
        Optional<Mission> result = Arrays.stream(Mission.values())
                .filter(mission -> mission.getName().equals(name)).findFirst();

        if (result.isPresent()) {
            return result.get();
        }
        throw new IllegalArgumentException(ERROR_MISSION_NOT_EXIST);
    }
}
