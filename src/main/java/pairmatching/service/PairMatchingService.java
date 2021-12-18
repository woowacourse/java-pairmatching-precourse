package pairmatching.service;

import java.util.List;

import pairmatching.domain.PairRepository;
import pairmatching.domain.Pairs;
import pairmatching.dto.RequestCourseAndLevelAndMissionDto;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class PairMatchingService {
	private PairRepository pairRepository;

	public PairMatchingService() {
		pairRepository = new PairRepository();
	}

	public void matching(RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto) {
		Course course = Course.getByValue(requestCourseAndLevelAndMissionDto.getCourse());
		List<String> shuffledCrew = course.getCrewNames();
		Pairs pairs = pairMatching(shuffledCrew, requestCourseAndLevelAndMissionDto.getMission());
		Level level = Level.getByValue(requestCourseAndLevelAndMissionDto.getLevel());
		pairRepository.setPair(level, pairs);
	}

	private Pairs pairMatching(List<String> shuffledCrew, String Mission) {
		Pairs pairs = new Pairs(Mission);
		if (isEven(shuffledCrew.size())) {
			makePairsEven(pairs, shuffledCrew);
			return pairs;
		}
		makePairsOdd(pairs, shuffledCrew);
		return pairs;
	}

	private boolean isEven(int number) {
		return number % 2 == 0;
	}

	private Pairs makePairsEven(Pairs pairs, List<String> shuffledCrew) {
		for (int i = 0; i < shuffledCrew.size(); i += 2) {
			String name1 = shuffledCrew.get(i);
			String name2 = shuffledCrew.get(i + 1);
			pairs.addPair(name1, name2);
		}
		return pairs;
	}

	private Pairs makePairsOdd(Pairs pairs, List<String> shuffledCrew) {
		for (int i = 0; i < shuffledCrew.size() - 3; i += 2) {
			String name1 = shuffledCrew.get(i);
			String name2 = shuffledCrew.get(i + 1);
			pairs.addPair(name1, name2);
		}
		String name1 = shuffledCrew.get(shuffledCrew.size() - 3);
		String name2 = shuffledCrew.get(shuffledCrew.size() - 2);
		String name3 = shuffledCrew.get(shuffledCrew.size() - 1);
		pairs.addPair(name1, name2, name3);
		return pairs;
	}
}
