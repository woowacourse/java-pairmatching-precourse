package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import pairmatching.util.Constants;

public enum Level {
	LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
	LEVEL3("레벨3", new ArrayList<>()),
	LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
	LEVEL5("레벨5", new ArrayList<>());

	private String name;
	private final List<String> missions;
	private HashSet<Pair> pairHashSet = new HashSet<>();

	Level(String name, List<String> missions) {
		this.name = name;
		this.missions = missions;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "	- " + name + ": " + String.join(Constants.PROCESS_SEPARATOR, missions);
	}

	public boolean isEqualLevel(String name) {
		return this.name.equals(name);
	}

	public boolean isEqualMission(String name) {
		return missions.stream().anyMatch(m -> m.equals(name));
	}

	public boolean checkPairInPast(Pair pair) {
		boolean havePair = pairHashSet.contains(pair);
		if(!havePair) {
			pairHashSet.add(pair);
		}
		return havePair;
	}
}