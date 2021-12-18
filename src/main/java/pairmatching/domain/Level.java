package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public enum Level {

	LEVEL_1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL_2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
	LEVEL_3("레벨3", Collections.emptyList()),
	LEVEL_4("레벨4", Arrays.asList("성능개선", "배포")),
	LEVEL_5("레벨5", Collections.emptyList());

	private final String level;
	private final List<String> missions;

	Level(String level, List<String> missions) {
		this.level = level;
		this.missions = missions;
	}

	public static String findLevelByMission(String element) {
		return Arrays.stream(Level.values())
			.filter(hasElementInGroup(element))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("포함되는 문자열 리스트 그룹이 없습니다."))
			.getLevel();
	}

	public String getLevel() {
		return this.level;
	}

	private static Predicate<Level> hasElementInGroup(String element) {
		return e -> e.missions.stream()
			.anyMatch(elementInStringList -> elementInStringList.equals(element));
	}


	public boolean isContains(String elementInStringList) {
		return this.missions.contains(elementInStringList);
	}


	public static boolean isContains(String group, String name) {
		return Arrays.stream(Level.values())
			.filter(enumVariable -> enumVariable.level.equals(group))
			.findAny()
			.orElseThrow(NoSuchElementException::new)
			.missions.contains(name);
	}

}

