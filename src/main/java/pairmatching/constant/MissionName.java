package pairmatching.constant;

import java.util.Arrays;
import java.util.List;

public enum MissionName {
	LEVEL1(Level.LEVEL1, "자동차경주", "로또", "숫자야구게임"),
	LEVEL2(Level.LEVEL2, "장바구니", "결제", "지하철노선도"),
	LEVEL3(Level.LEVEL3),
	LEVEL4(Level.LEVEL4, "성능개선", "배포"),
	LEVEL5(Level.LEVEL5);

	private final Level level;
	private final List<String> names;

	MissionName(Level level, String... names) {
		this.level = level;
		this.names = Arrays.asList(names);
	}

	public Level getLevel() {
		return level;
	}

	public List<String> getNames() {
		return names;
	}

	public int size() {
		return names.size();
	}

	public boolean isEmpty() {
		return names.isEmpty();
	}

	public static List<String> ofLevel(Level level) {
		return Arrays.stream(MissionName.values())
			.filter(missionName -> missionName.level.equals(level))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR]" + "그런 미션은 없습니다"))
			.getNames();
	}
}
