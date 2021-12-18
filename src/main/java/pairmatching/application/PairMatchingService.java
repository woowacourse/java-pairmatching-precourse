package pairmatching.application;

import java.util.Arrays;
import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.MissionRepository;

public class PairMatchingService {
	public List<String> match(String course, String level, String mission) {
		validate(course, level, mission);
		return null;
	}

	private void validate(String courseName, String levelName, String missionName) {
		validateIsExistValue(courseName, levelName, missionName);
		validateIsMatchedLevelAndMission(levelName, missionName);
	}

	private void validateIsExistValue(String courseName, String levelName, String missionName) {
		if (!isValidCourse(courseName)) {
			throw new IllegalArgumentException("과정 이름이 잘못되었습니다.");
		}
		if (!isValidLevel(levelName)){
			throw new IllegalArgumentException("레벨 이름이 잘못되었습니다.");
		}
		if (!MissionRepository.existsByName(missionName)) {
			throw new IllegalArgumentException("미션 이름이 잘못되었습니다.");
		}
	}

	private boolean isValidCourse(String course) {
		return Arrays.stream(Course.values()).anyMatch(c -> c.getName().equals(course));
	}

	private boolean isValidLevel(String level) {
		return Arrays.stream(Level.values()).anyMatch(l -> l.getName().equals(level));
	}

	private void validateIsMatchedLevelAndMission(String levelName, String missionName) {
		Level level = Level.valueByName(levelName);
		Mission mission = MissionRepository.findByName(missionName);

		if(!mission.getLevel().equals(level)) {
			throw new IllegalArgumentException("레벨에 맞는 미션이 없습니다.");
		}
	}
}
