package pairmatching.model;

public enum Level {
	LEVEL1("레벨1", Missions.init("자동차경주,로또,숫자야구게임")),
	LEVEL2("레벨2", Missions.init("장바구니,결제,지하철노선도")),
	LEVEL3("레벨3", Missions.init("")),
	LEVEL4("레벨4", Missions.init("성능개선,배포")),
	LEVEL5("레벨5", Missions.init("")); //TODO 미션 init에 빈 문자열 넣어도 nullpointerException터지지 않는지 확인

	private String name;
	private Missions missionList;

	Level(String name, Missions missionList) {
		this.name = name;
		this.missionList = missionList;
	}
}
