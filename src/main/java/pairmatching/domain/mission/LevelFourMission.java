package pairmatching.domain.mission;

public enum LevelFourMission implements Mission {
	PERFORMANCE_IMPROVEMENT("성능개선"),
	DISTRIBUTION("배포");

	private String name;

	LevelFourMission(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
