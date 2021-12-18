package pairmatching.service;

import static pairmatching.utils.Constant.*;
import static pairmatching.view.ErrorMessage.*;

import pairmatching.domain.MatchingInfo;
import pairmatching.repository.MatchingRepository;

import java.util.List;

public class PairMatchingService {
	private final MatchingRepository matchingRepository = MatchingRepository.getInstance();

	public boolean checkInList(List<String> infos) {
		String course = infos.get(COURSE_INFO);
		String level = infos.get(LEVEL_INFO);
		String mission = infos.get(MISSION_INFO);
		checkExistInfos(course, level, mission);

		return true;
	}

	public boolean isMatched(List<String> matchInfos) {
		List<MatchingInfo> matchedInfo = matchingRepository.findAll();
		return matchedInfo.stream().anyMatch(m -> m.isSame(matchInfos));
	}

	private void checkExistInfos(String course, String level, String mission) {
		checkExistCourse(course);
		String selectedLevel = checkExistLevel(level);
		checkExistMission(selectedLevel, mission);
	}

	private void checkExistCourse(String course) {
		if (!isExist(course, COURSE)) {
			throw new IllegalArgumentException(ERROR_NOT_EXISTED_COURSE);
		}
	}

	private String checkExistLevel(String level) {
		if (!isExist(level, LEVEL_LABELS)) {
			throw new IllegalArgumentException(ERROR_NOT_EXISTED_LEVEL);
		}

		return LEVEL_LABELS.stream()
				.filter(e -> e.equals(level)).findFirst().orElse(null);
	}

	private void checkExistMission(String level, String mission) {
		if (level.equals(LEVEL_1_LABEL)) {
			if (isExistLevelMission(mission, LEVEL_1)) return;
		} else if (level.equals(LEVEL_2_LABEL)) {
			if (isExistLevelMission(mission, LEVEL_2)) return;
		} else if (level.equals(LEVEL_3_LABEL)) {
			if (isExistLevelMission(mission, LEVEL_3)) return;
		} else if (level.equals(LEVEL_4_LABEL)) {
			if (isExistLevelMission(mission, LEVEL_4)) return;
		} else if (level.equals(LEVEL_5_LABEL)) {
			if (isExistLevelMission(mission, LEVEL_5)) return;
		}
		throw new IllegalArgumentException(ERROR_NOT_EXISTED_MISSION);
	}

	private boolean isExistLevelMission(String mission, List<String> level1) {
		if (isExist(mission, level1)) {
			return true;
		}
		return false;
	}

	private boolean isExist(String element, List<String> type) {
		return type.stream().anyMatch(t -> t.equals(element));
	}
}
