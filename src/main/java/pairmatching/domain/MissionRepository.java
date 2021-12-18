package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissionRepository {
	private static final List<Mission> missions = new ArrayList<>();

	static {
		for (Course course : Course.values()) {
			missions.add(new Mission("자동차경주", course, Level.LEVEL1));
			missions.add(new Mission("로또", course, Level.LEVEL1));
			missions.add(new Mission("숫자야구게임", course, Level.LEVEL1));
			missions.add(new Mission("장바구니", course, Level.LEVEL2));
			missions.add(new Mission("결제", course, Level.LEVEL2));
			missions.add(new Mission("지하철노선도", course, Level.LEVEL2));
			missions.add(new Mission("성능개선", course, Level.LEVEL4));
			missions.add(new Mission("배포", course, Level.LEVEL4));
		}
	}

	public static List<Mission> missions() {
		return Collections.unmodifiableList(missions);
	}

	public static void addMission(Mission mission) {
		missions.add(mission);
	}

	public static Mission findMissionByName(List<String> courseLevelMission) {
		return missions.stream()
			.filter(mission -> mission.isSameCourse(Course.of(courseLevelMission.get(0))))
			.filter(mission -> mission.isSameLevel(Level.of(courseLevelMission.get(1))))
			.filter(mission -> mission.isSameName(courseLevelMission.get(2)))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("올바르지 않은 입력입니다."));
	}
}
