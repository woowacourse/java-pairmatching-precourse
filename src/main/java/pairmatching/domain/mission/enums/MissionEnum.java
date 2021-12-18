package pairmatching.domain.mission.enums;

import java.util.Arrays;
import java.util.List;

public enum MissionEnum {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    MARKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    PERFORMANCE("성능개선"),
    DEPLOYMENT("배포");

    private String name;

    MissionEnum(String name) {
        this.name = name;
    }

    public List<MissionEnum> getLevelOneMissions() {
        return Arrays.asList(CAR_RACING, LOTTO, BASEBALL);
    }

    public List<MissionEnum> getLevelTwoMissions() {
        return Arrays.asList(MARKET, PAYMENT, SUBWAY);
    }

    public List<MissionEnum> getLevelFourMissions() {
        return Arrays.asList(PERFORMANCE, DEPLOYMENT);
    }
}
