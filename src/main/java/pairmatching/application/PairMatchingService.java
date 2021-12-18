package pairmatching.application;

import java.util.Arrays;
import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.MissionRepository;
import pairmatching.model.Pair;
import pairmatching.model.PairRepository;

public class PairMatchingService {
	private final PairGenerator pairGenerator = new PairGenerator();

	public boolean hasMatched(String courseName, String missionName) {
		validateCourseName(courseName);
		validateMissionName(missionName);
		return PairRepository.existsByMission(parseToMission(missionName, courseName));
	}

	public List<Pair> match(String courseName, String levelName, String missionName) {
		validate(courseName, levelName, missionName);
		Mission mission = parseToMission(missionName, courseName);
		List<Pair> pairList = pairGenerator.generate(mission);
		PairRepository.saveAll(pairList);
		return pairList;
	}

	public List<Pair> findByCourseAndMission(String courseName, String missionName) {
		validateCourseName(courseName);
		validateMissionName(missionName);
		return PairRepository.findByCourseAndMission(parseToMission(missionName, courseName));
	}

	private void validate(String courseName, String levelName, String missionName) {
		validateNames(courseName, levelName, missionName);
		validateIsMatchedLevelAndMission(courseName, levelName, missionName);
	}

	private void validateNames(String courseName, String levelName, String missionName) {
		validateCourseName(courseName);
		validateLevelName(levelName);
		validateMissionName(missionName);
	}

	private void validateCourseName(String courseName) {
		if (!isValidCourse(courseName)) {
			throw new IllegalArgumentException("과정 이름이 잘못되었습니다.");
		}
	}

	private void validateLevelName(String levelName) {
		if (!isValidLevel(levelName)){
			throw new IllegalArgumentException("레벨 이름이 잘못되었습니다.");
		}
	}

	private void validateMissionName(String missionName) {
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

	private void validateIsMatchedLevelAndMission(String courseName, String levelName, String missionName) {
		Level level = Level.valueByName(levelName);
		Mission mission = parseToMission(missionName, courseName);

		if(!mission.getLevel().equals(level)) {
			throw new IllegalArgumentException("레벨에 맞는 미션이 없습니다.");
		}
	}

	private Mission parseToMission(String name, String courseName) {
		return MissionRepository.findByNameAndCourse(name, parseToCourse(courseName));
	}

	private Course parseToCourse(String name) {
		return Course.valueByName(name);
	}
}
