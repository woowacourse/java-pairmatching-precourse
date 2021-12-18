package pairmatching.application;

import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Mission;
import pairmatching.model.MissionRepository;
import pairmatching.model.Pair;
import pairmatching.model.PairRepository;

public class PairMatchingService {
	private final PairGenerator pairGenerator = new PairGenerator();

	public boolean hasMatched(String courseName, String missionName) {
		return PairRepository.existsByMission(parseToMission(missionName, courseName));
	}

	public List<Pair> match(String courseName, String levelName, String missionName) {
		Mission mission = parseToMission(missionName, courseName);
		List<Pair> pairList = pairGenerator.generate(mission);
		PairRepository.saveAll(pairList);
		return pairList;
	}

	public List<Pair> findByCourseAndMission(String courseName, String missionName) {
		if (!PairRepository.existByMission(parseToMission(missionName, courseName))) {
			throw new IllegalArgumentException("매칭 이력이 없습니다.");
		}

		return PairRepository.findByCourseAndMission(parseToMission(missionName, courseName));
	}

	public void initializeMatchedPair() {
		PairRepository.deleteAll();
	}

	private Mission parseToMission(String name, String courseName) {
		return MissionRepository.findByNameAndCourse(name, parseToCourse(courseName));
	}

	private Course parseToCourse(String name) {
		return Course.valueByName(name);
	}
}
