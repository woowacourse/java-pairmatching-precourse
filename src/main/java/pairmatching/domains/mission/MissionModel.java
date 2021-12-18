package pairmatching.domains.mission;

import static pairmatching.constant.ErrorMessages.*;
import static pairmatching.constant.ViewMessage.*;
import static pairmatching.domains.mission.Level.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum MissionModel {
	RACING_CAR(LEVEL1, "자동차경주"),
	LOTTO(LEVEL1, "로또"),
	NUMBER_BASEBALL(LEVEL1, "숫자야구게임"),
	CART(LEVEL2, "장바구니"),
	PAY(LEVEL2, "결제"),
	SUBWAY(LEVEL2, "지하철노선도"),
	PERFORMANCE(LEVEL4, "성능개선"),
	DEPLOY(LEVEL4, "배포");

	private Level level;
	private String korean;

	MissionModel(Level level, String korean) {
		this.level = level;
		this.korean = korean;
	}

	public static String getMissionViewByLevel(Level level) {
		 return Arrays.stream(MissionModel.values())
			 .filter(m -> m.level == level)
			 .map(m -> m.korean)
			 .collect(Collectors.joining(STATE_DIVIDER));
	}

	public static MissionModel findByString(String level, String missionName) {
		return Arrays.stream(MissionModel.values())
			.filter(s -> s.level.getName().equals(level))
			.filter(s -> s.korean.equals(missionName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(
				MISSION_NULL + LINE_BREAK
			));
	}
}
