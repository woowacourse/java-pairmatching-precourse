package pairmatching;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Mission {
	RACING_CAR("자동차경주", Level.LEVEL1),
	LOTTO("로또", Level.LEVEL1),
	BASEBALL_GAME("숫자야구게임", Level.LEVEL1),
	SHOPPING_BASKET("장바구니", Level.LEVEL2),
	PAYMENT("결제", Level.LEVEL2),
	SUBWAY_MAP("지하철노선도", Level.LEVEL2),
	PERFORMANCE_IMPROVEMENT("성능개선", Level.LEVEL4),
	DISTRIBUTION("배포", Level.LEVEL4);

	private static final String ERROR_NOT_FOUND = "해당 미션은 존재하지 않습니다.";
	private static final String ERROR_WRONG_LEVEL = "해당 미션과 레벨이 일치하지 않습니다.";

	private String name;
	private Level level;

	Mission(String name, Level level) {
		this.name = name;
		this.level = level;
	}

	public String toString() {
		return name;
	}

	public static List<Mission> findMissionByLevel(Level level) {
		return Arrays.stream(Mission.values()).filter(mission -> mission.level == level).collect(Collectors.toList());
	}

	public static Mission validateChoose(String name) {
		return Arrays.stream(Mission.values())
			.filter(mission -> mission.name.equals(name))
			.findFirst()
			.orElseThrow(() ->
				new IllegalArgumentException(ERROR_NOT_FOUND));
	}

	public void validateMissionWithLevel(Level level) {
		if (this.level != level) {
			throw new IllegalArgumentException(ERROR_WRONG_LEVEL);
		}
	}
}
