package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MissionRepository {
	static final String ERROR_NOT_EXIST_MISSION = "존재하지 않는 미션입니다.";

	private static final List<Mission> missions = new ArrayList<>();

	public static void initMission() {
		for(Course course: Course.values()) {
			missions.add(new Mission(course, Level.LEVEL1, "자동차경주"));
			missions.add(new Mission(course, Level.LEVEL1, "로또"));
			missions.add(new Mission(course, Level.LEVEL1, "숫자야구게임"));
			missions.add(new Mission(course, Level.LEVEL2, "장바구니"));
			missions.add(new Mission(course, Level.LEVEL2, "결제"));
			missions.add(new Mission(course, Level.LEVEL2, "지하철노선도"));
			missions.add(new Mission(course, Level.LEVEL4, "성능개선"));
			missions.add(new Mission(course, Level.LEVEL4, "배포"));
		}
	}

	public static Mission getMission(List<String> missionInput) {
		return missions.stream()
			.filter((mission) -> mission.isMatchMission(missionInput))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_EXIST_MISSION));
	}

	public static List<Mission> getMissionsOfSameGroup(Course course, Level level) {
		return missions.stream()
			.filter(mission -> mission.isSameCourse(course))
			.filter(mission -> mission.isSameLevel(level))
			.collect(Collectors.toList());
	}
}
