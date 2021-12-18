package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
	LEVEL1("레벨1", Arrays.asList(Mission.RACING_CAR, Mission.LOTTO, Mission.NUMBER_BASEBALL)),
	LEVEL2("레벨2", Arrays.asList(Mission.SHOP_BASKET, Mission.PAYMENT, Mission.SUBWAY_MAP)),
	LEVEL3("레벨3", Collections.emptyList()),
	LEVEL4("레벨4", Arrays.asList(Mission.PERFORMANCE_IMPROVEMENT, Mission.DEPLOYMENT)),
	LEVEL5("레벨5", Collections.emptyList());

	private static final String ERROR_OF = "해당하는 레벨이 없습니다.";
	private String name;
	private List<Mission> missions;

	Level(String name, List<Mission> missions) {
		this.name = name;
		this.missions = missions;
	}

	public static Level of(String str) {
		return Arrays.stream(values())
			.filter(level -> level.name.equals(str))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_OF));
	}

	public boolean contains(Mission other) {
		return missions.stream().anyMatch(mission -> mission == other);
	}
}
