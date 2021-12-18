package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public enum Mission {
	LEVEL1_MISSION(Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL2_MISSION(Arrays.asList("장바구니", "결제", "지하철노선도")),
	LEVEL3_MISSION(Arrays.asList("")),
	LEVEL4_MISSION(Arrays.asList("성능개선", "배포")),
	LEVEL5_MISSION(Arrays.asList(""));

	private List<String> missionList;

	Mission(final List<String> missionList) {
		this.missionList = missionList;
	}

	public List<String> getMissionList() {
		return missionList;
	}
}
