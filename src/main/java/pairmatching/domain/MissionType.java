package pairmatching.domain;

import java.util.Arrays;

public enum MissionType {

	RACING_CAR("자동차경주"),
	LOTTO("로또"),
	NUMBER_BASEBALL("숫자야구게임"),
	BASKET("장바구니"),
	PAYMENT("결제"),
	SUBWAY_LINE_MAP("지하철노선도"),
	PERFORMANCE_IMPROVEMENT("성능개선"),
	DISTRIBUTION("배포");

	private static final String ERROR_NOT_MISSION = " 은 등록되지 않은 미션입니다.";
	private final String name;

	MissionType(String name) {
		this.name = name;
	}

	public static MissionType findByMission(String command) {
		return Arrays.stream(MissionType.values())
			.filter(mission -> mission.name.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_MISSION));
	}
}
