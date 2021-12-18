package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Mission {
	RACING_CAR("자동차경주", Level.LEVEL1),
	LOTTO("로또", Level.LEVEL1),
	BASEBALL("숫자야구게임", Level.LEVEL1),
	CART("장바구니", Level.LEVEL2),
	PAYMENT("결제", Level.LEVEL2),
	SUBWAY("지하철노선도", Level.LEVEL2),
	IMPROVEMENT_PERFORMANCE("성능개선", Level.LEVEL4),
	DISTRIBUTION("배포",Level.LEVEL4);

	private String name;
	private Level level;

	Mission(String name, Level level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public static List<Mission> getByLevel(Level level) {
		return Arrays.stream(Mission.values())
			.filter(mission -> mission.level == level)
			.collect(Collectors.toList());
	}

	public static Mission getByName(String name) {
		return Arrays.stream(Mission.values())
			.filter(mission -> mission.name.equals(name))
			.findFirst()
			.orElse(null);
	}
}
