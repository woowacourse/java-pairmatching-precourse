package pairmatching.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingOption;
import pairmatching.domain.Mission;
import pairmatching.domain.Missions;

public class Converter {
	public static MatchingOption toMatchingOption(String input, Missions missions) {
		Pattern pattern = PairMatchingSelectOptionPattern.getPattern();
		Matcher matcher = pattern.matcher(input);
		Validator.validateMatcher(matcher);
		String courseName = matcher.group(1);
		String levelName = matcher.group(2);
		String missionName = matcher.group(3);
		Mission mission = missions.getByMissionName(missionName);
		Validator.validateMissionLevel(mission, levelName);

		return new MatchingOption(
			Course.getCourseByName(courseName),
			missions.getByMissionName(missionName));
	}

	private static void validateMissionLevel(Missions missions, String levelName, String missionName) {

	}
}
