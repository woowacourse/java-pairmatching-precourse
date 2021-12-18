package pairmatching.service;

import static pairmatching.enums.ErrorMessage.*;

import java.util.List;

import pairmatching.domain.MissionList;
import pairmatching.domain.PairRepository;
import pairmatching.domain.Pairs;
import pairmatching.dto.RequestCourseAndLevelAndMissionDto;
import pairmatching.dto.ResponsePairsDto;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class PairMatchingService {
	private PairRepository pairRepository;

	public PairMatchingService() {
		pairRepository = new PairRepository();
	}

	public void matching(RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto) {
		Level level = requestCourseAndLevelAndMissionDto.getLevel();
		Course course = requestCourseAndLevelAndMissionDto.getCourse();
		String mission = requestCourseAndLevelAndMissionDto.getMission();
		Pairs pairs = new Pairs(level, course, mission);
		if (pairRepository.hasPairs(level, course, mission)) {
			pairs = pairRepository.getPairs(level, course, mission);
		}
		List<String> shuffledCrew = course.getCrewNames();
		pairMatching(shuffledCrew, pairs);
		if (pairRepository.hasPairs(level, course, mission)) {
			return;
		}
		pairRepository.addPairsList(pairs);
	}

	private void pairMatching(List<String> shuffledCrew, Pairs pairs) {
		if (isEven(shuffledCrew.size())) {
			makePairsEven(pairs, shuffledCrew);
			return;
		}
		makePairsOdd(pairs, shuffledCrew);
	}

	private boolean isEven(int number) {
		return number % 2 == 0;
	}

	private void makePairsEven(Pairs pairs, List<String> shuffledCrew) {
		for (int i = 0; i < shuffledCrew.size(); i += 2) {
			String name1 = shuffledCrew.get(i);
			String name2 = shuffledCrew.get(i + 1);
			pairs.addPair(name1, name2);
		}
	}

	private void makePairsOdd(Pairs pairs, List<String> shuffledCrew) {
		for (int i = 0; i < shuffledCrew.size() - 3; i += 2) {
			String name1 = shuffledCrew.get(i);
			String name2 = shuffledCrew.get(i + 1);
			pairs.addPair(name1, name2);
		}
		String name1 = shuffledCrew.get(shuffledCrew.size() - 3);
		String name2 = shuffledCrew.get(shuffledCrew.size() - 2);
		String name3 = shuffledCrew.get(shuffledCrew.size() - 1);
		pairs.addPair(name1, name2, name3);
	}

	public ResponsePairsDto getPairs(RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto) {
		Level level = requestCourseAndLevelAndMissionDto.getLevel();
		Course course = requestCourseAndLevelAndMissionDto.getCourse();
		String mission = requestCourseAndLevelAndMissionDto.getMission();
		return new ResponsePairsDto(pairRepository.getPairs(level, course, mission));
	}

	public boolean hasPairs(RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto) {
		Level level = requestCourseAndLevelAndMissionDto.getLevel();
		Course course = requestCourseAndLevelAndMissionDto.getCourse();
		String mission = requestCourseAndLevelAndMissionDto.getMission();
		return pairRepository.hasPairs(level, course, mission);
	}

	public void validatePairs(RequestCourseAndLevelAndMissionDto requestCourseAndLevelAndMissionDto) {
		Level level = requestCourseAndLevelAndMissionDto.getLevel();
		Course course = requestCourseAndLevelAndMissionDto.getCourse();
		String mission = requestCourseAndLevelAndMissionDto.getMission();
		if (new MissionList().hasMission(level, mission)) {
			return;
		}
		throw new IllegalArgumentException(NO_HAS_MISSION_ERROR.get());
	}

	public void init() {
		pairRepository.init();
	}
}
