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

    public List<String> getLevelMission(String level){
        if (level.equals(Level.LEVEL1.getName())){
            return level1Mission;
        }
        if (level.equals(Level.LEVEL2.getName())){
            return level2Mission;
        }
        if (level.equals(Level.LEVEL3.getName())){
            return level3Mission;
        }
        if (level.equals(Level.LEVEL4.getName())){
            return level4Mission;
        }
        return level5Mission;
    }
}
