package pairmatching;

import pairmatching.view.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Mission {
    LEVEL1(Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2(Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3(Arrays.asList()),
    LEVEL4(Arrays.asList("성능개선", "배포")),
    LEVEL5(Arrays.asList());

    private List<String> missions;

    Mission(List<String> missions) {
        this.missions = missions;
    }

    public String getMission() {
        String s = String.join(Constant.OR, missions);
        return s;
    }

    public List<String> get() {
        return missions;
    }
}
