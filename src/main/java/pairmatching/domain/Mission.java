package pairmatching.domain;

import static pairmatching.ErrorMessage.*;

import java.util.Arrays;

import com.sun.org.apache.xpath.internal.objects.XString;

public enum Mission {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    NUM_BASEBALL("숫자야구게임"),
    SHOPPRING_CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY_LINE("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DEPLOYMENT("배포");

    private String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission find(String name) {
        return Arrays.stream(Mission.values())
            .filter(mission -> mission.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(NO_OBJECT_ERROR));
    }

    public String getName() {
        return name;
    }
}
