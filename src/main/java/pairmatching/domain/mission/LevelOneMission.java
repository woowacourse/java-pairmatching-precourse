package pairmatching.domain.mission;

public enum LevelOneMission implements Mission {
	RACING_CAR("자동차경주"),
	LOTTO("로또"),
	NUMBER_BASEBALL("숫자야구게임");

	private String name;

	LevelOneMission(String name) {
		this.name = name;
	}
}
