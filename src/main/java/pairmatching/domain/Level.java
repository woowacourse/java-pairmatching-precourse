package pairmatching.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Level {
	private Map<String, List<String>> levelMap = new LinkedHashMap<>();

	public Level() {
		initLevelMap();
	}

	public Map<String, List<String>> getLevelMap() {
		return levelMap;
	}

	private void initLevelMap() {
		levelMap.put("레벨 1", Arrays.asList("자동차경주","로또", "숫자야구게임"));
		levelMap.put("레벨 2", Arrays.asList("장바구니","결제", "지하철노선도"));
		levelMap.put("레벨 3", Arrays.asList(" "));
		levelMap.put("레벨 4", Arrays.asList("성능개선", "배포"));
		levelMap.put("레벨 5", Arrays.asList(" "));
	}
}
