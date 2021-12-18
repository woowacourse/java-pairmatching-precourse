package pairmatching.domain;

import static constants.PairMatchingConstants.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
	LEVEL1("레벨1", Arrays.asList(Mission.CAR_RACING, Mission.LOTTO, Mission.BASEBALL)),
	LEVEL2("레벨2", Arrays.asList(Mission.SHOPPING_CART, Mission.PAYMENT, Mission.SUBWAY)),
	LEVEL3("레벨3", Collections.emptyList()),
	LEVEL4("레벨4", Arrays.asList(Mission.PERFORMANCE_IMPROVEMENT, Mission.DEPLOYMENT)),
	LEVEL5("레벨5", Collections.emptyList());

	private String name;
	private List<Mission> missions;

	Level(String name, List<Mission> missions) {
		this.name = name;
		this.missions = missions;
	}

	public static Level findByName(String name) {
		return Arrays.stream(Level.values())
			.filter(level -> level.checkName(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(WRONG_LEVEL_ERROR));
	}

	private boolean checkName(String name) {
		return this.name.equals(name);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(LIST_PREFIX + name + COLON);
		if (missions.isEmpty())
			return result.toString();

		for (int idx = 0; idx < missions.size() - 1; idx++) {
			result.append(missions.get(idx) + SEPARATOR);
		}
		result.append(missions.get(missions.size() - 1));
		return result.toString();
	}
}