package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pairmatching.domain.Mission.*;

public enum Level {
	LEVEL1("레벨1", Arrays.asList(
		RACING_CAR, LOTTERY, NUMBER_BASEBALL_GAME
	)),
	LEVEL2("레벨2", Arrays.asList(
		SHOPPING_BASKET, PAYMENT, SUBWAY_MAP
	)),
	LEVEL3("레벨3", new ArrayList<>()),
	LEVEL4("레벨4", Arrays.asList(
		IMPROVED_PERFORMANCE, DISTRIBUTE
	)),
	LEVEL5("레벨5", new ArrayList<>());

	private String name;
	private List<Mission> missions = new ArrayList<Mission>();

	Level(String name, List<Mission> missions) {
		this.name = name;
	}

	// 추가 기능 구현
}
