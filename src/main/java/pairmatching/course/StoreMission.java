package pairmatching.course;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.course.Level.*;

public class StoreMission {

    public void storePerLevelMission() {
        LEVEL1.setMissionList(level1Mission());
        LEVEL2.setMissionList(level2Mission());
        LEVEL3.setMissionList(level3Mission());
        LEVEL4.setMissionList(level4Mission());
        LEVEL5.setMissionList(level5Mission());
    }

    public List<String> level1Mission() {
        List<String> mission = new ArrayList<>();
        mission.add("자동차경주");
        mission.add("로또");
        mission.add("숫자야구게임");
        return mission;
    }

    public List<String> level2Mission() {
        List<String> mission = new ArrayList<>();
        mission.add("장바구니");
        mission.add("결제");
        mission.add("지하철노선도");
        return mission;
    }

    public List<String> level3Mission() {
        List<String> mission = new ArrayList<>();
        return mission;
    }

    public List<String> level4Mission() {
        List<String> mission = new ArrayList<>();
        mission.add("성능개선");
        mission.add("배포");
        return mission;
    }

    public List<String> level5Mission() {
        List<String> mission = new ArrayList<>();
        return mission;
    }
}
