package pairmatching.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pairmatching.constant.PairMatchingConst;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Missions;

public class Validator {
	public static void validateSelection(String userSelection) {
		List<String> validSelections = Arrays.asList(
			PairMatchingConst.SELECT_PAIR_MATCHING,
			PairMatchingConst.SELECT_PAIR_READ,
			PairMatchingConst.SELECT_PAIR_RESET,
			PairMatchingConst.SELECT_EXIT);

		if (!validSelections.contains(userSelection)) {
			throw new IllegalArgumentException("[ERROR] 지정된 입력만 입력가능합니다.");
		}
	}

	public static void validateMatcher(Matcher m) {
		if (!m.matches()) {
			throw new IllegalArgumentException("[ERROR] 지정된 형식으로 입력해야합니다.");
		}
	}

	public static void validateMissionLevel(Mission mission, String levelName) {
		if (!mission.isLevel(Level.getLevelByName(levelName))) {
			throw new IllegalArgumentException("[ERROR] 입력한 레벨에 해당 미션이 존재하지 않습니다.");
		}

	}

	// public static void validateCourse(String courseName) {
	// 	if(!Course.haveName(courseName)){
	// 		throw new IllegalArgumentException("[ERROR] 입력한 과정은 존재하지 않습니다.");
	// 	}
	// }
	//
	// public static void validateLevel(String levelName) {
	// 	if(!Level.haveName(levelName)){
	// 		throw new IllegalArgumentException("[ERROR] 입력한 레벨은 존재하지 않습니다.");
	// 	}
	// }
	//
	// public static void validateMission(String missionName, Missions missions) {
	// 	if(!missions.haveName(missionName)){
	// 		throw new IllegalArgumentException("[ERROR] 입력한 미션은 존재하지 않습니다.");
	// 	}
	// }
}
