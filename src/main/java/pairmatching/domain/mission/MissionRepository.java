package pairmatching.domain.mission;

import java.util.HashMap;
import java.util.Map;

import pairmatching.domain.Level;

public class MissionRepository {
    private Map<String, Mission> missions = new HashMap<>();

    public void createMissions() {
        missions.put("자동차경주", new Mission(Level.LEVEL1, "자동차경주"));
        missions.put("로또", new Mission(Level.LEVEL1, "로또"));
        missions.put("숫자야구게임", new Mission(Level.LEVEL1, "숫자야구게임"));
        missions.put("장바구니", new Mission(Level.LEVEL2, "장바구니"));
        missions.put("결제", new Mission(Level.LEVEL2, "결제"));
        missions.put("지하철노선도", new Mission(Level.LEVEL2, "지하철노선도"));
        missions.put("성능개선", new Mission(Level.LEVEL3, "성능개선"));
        missions.put("배포", new Mission(Level.LEVEL3, "배포"));
        System.out.println(missions);
    }
}
