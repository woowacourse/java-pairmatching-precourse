package pairmatching.domain;

public enum Level {
	LEVEL1("레벨1", new Mission[] {Mission.BASEBALL_GAME, Mission.LOTTO, Mission.BASEBALL_GAME}),
	LEVEL2("레벨2", new Mission[] {Mission.SHOPPING_CART, Mission.PAYMENT, Mission.SUBWAY_MAP}),
	LEVEL3("레벨3", new Mission[] {}),
	LEVEL4("레벨4", new Mission[] {Mission.PERFORMANCE_IMPROVEMENT, Mission.DISTRIBUTION}),
	LEVEL5("레벨5", new Mission[] {});

	private String name;
	private Mission[] mission;

	Level(String name, Mission[] mission) {
		this.name = name;
		this.mission = mission;
	}

	// 추가 기능 구현
}
