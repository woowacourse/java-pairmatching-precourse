package pairmatching.model;

import java.util.HashMap;
import java.util.Map;

public class LevelMission {
	public String[] level = {"레벨1", "레벨2", "레벨3", "레벨4", "레벨5"};
	public Map<String, Integer> mission;

	public LevelMission() {
		mission = new HashMap<String, Integer>();

		mission.put("숫자야구게임", 0);
		mission.put("로또", 0);
		mission.put("자동차경주", 0);

		mission.put("장바구니", 1);
		mission.put("결제", 1);
		mission.put("지하철노선도", 1);

		mission.put("성능개선", 3);
		mission.put("배포", 3);
	}
}
