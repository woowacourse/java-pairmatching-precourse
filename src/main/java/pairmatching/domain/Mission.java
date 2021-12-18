package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Mission {
	RACING_CAR("자동차경주", Level.LEVEL1),
	LOTTO("로또", Level.LEVEL1),
	BASEBALL("숫자야구게임",  Level.LEVEL1),
	SHOPPING_LIST("장바구니", Level.LEVEL2),
	PAYMENT("결제", Level.LEVEL2),
	SUBWAY_MAP("지하철노선도", Level.LEVEL2),
	PERFORMANCE("성능개선", Level.LEVEL4),
	RELEASE("배포", Level.LEVEL4);

	private final String name;
	private final Level level;

	Mission(String name, Level level) {
		this.name = name;
		this.level = level;
	}

	public static List<String> nameListOf(Level level) {
		return Arrays.stream(values())
			.filter(m -> m.level == level)
			.map(m -> m.name)
			.collect(Collectors.toList());
	}

	public static boolean isContains(String str) {
		return Arrays.stream(values())
			.map(f -> f.name)
			.anyMatch(k -> k.equals(str));
	}

	public static Mission byName(String name) {
		return Arrays.stream(values())
			.filter(f -> f.name.equals(name))
			.findFirst()
			.orElse(null);
	}

	public boolean isInLevel(Level level) {
		return level == this.level;
	}
}
