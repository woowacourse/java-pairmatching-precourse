package pairmatching.domain;

public enum Level {
	LEVEL1("레벨1", new Mission[] {Mission.CAR_RACING, Mission.LOTTO, Mission.BASEBALL_GAME}),
	LEVEL2("레벨2", new Mission[] {Mission.SHOPPING_CART, Mission.PAYMENT, Mission.SUBWAY_MAP}),
	LEVEL3("레벨3", new Mission[] {}),
	LEVEL4("레벨4", new Mission[] {Mission.PERFORMANCE_IMPROVEMENT, Mission.DISTRIBUTION}),
	LEVEL5("레벨5", new Mission[] {});

	private final String name;
	private final Mission[] missions;

	Level(String name, Mission[] missions) {
		this.name = name;
		this.missions = missions;
	}

	public String getName() {
		return name;
	}

	public Mission[] getMissions() {
		return missions;
	}
}
