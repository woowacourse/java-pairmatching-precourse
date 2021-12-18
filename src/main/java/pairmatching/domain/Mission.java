package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    List<String> level1Mission = new ArrayList<>();
    List<String> level2Mission = new ArrayList<>();
    List<String> level3Mission = new ArrayList<>();
    List<String> level4Mission = new ArrayList<>();
    List<String> level5Mission = new ArrayList<>();

    public Mission() {
        level1Mission.add("자동차경주");
        level1Mission.add("로또");
        level1Mission.add("숫자야구게임");

        level2Mission.add("장바구니");
        level2Mission.add("결제");
        level2Mission.add("지하철노선도");

        level4Mission.add("성능개선");
        level4Mission.add("배포");
    }

    public List<String> getLevel1Mission() {
        StringBuilder missions;

        return level1Mission;
    }

    public List<String> getLevel2Mission() {
        return level2Mission;
    }

    public List<String> getLevel3Mission() {
        return level3Mission;
    }

    public List<String> getLevel4Mission() {
        return level4Mission;
    }

    public List<String> getLevel5Mission() {
        return level5Mission;
    }
}
