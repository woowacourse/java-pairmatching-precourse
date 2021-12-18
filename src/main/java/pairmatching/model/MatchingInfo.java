package pairmatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constants.ExceptionMessages;

public class MatchingInfo {
	private String level;
	private String mission;
	private List<Crew> crewList = new ArrayList<>();

	public static final int LAST_PAIR_SIZE = 3;

	public MatchingInfo(List<String> crewNames, String matchingInfoString, Levels levels) {
		validateMatchingInfo(matchingInfoString, levels);
		List<String> infoStringList = Arrays.asList(matchingInfoString.split(", "));
		List<String> shuffledCrew = Randoms.shuffle(crewNames);
		int numberOfCrews = shuffledCrew.size();
		this.level = infoStringList.get(1);
		this.mission = infoStringList.get(2);

		if (numberOfCrews % 2 == 0) {
			for (int i = 0; i < numberOfCrews; i += 2) {
				List<Crew> crewList = new ArrayList<>();
				crewList.add(new Crew(Course.getCourseByString(infoStringList.get(0)), shuffledCrew.get(i)));
				crewList.add(new Crew(Course.getCourseByString(infoStringList.get(0)), shuffledCrew.get(i + 1)));
			}
			return;
		}
		for (int i = 0; i < numberOfCrews; i += 2) {
			if (i == numberOfCrews - LAST_PAIR_SIZE) {
				crewList.add(new Crew(Course.getCourseByString(infoStringList.get(0)), shuffledCrew.get(i)));
				crewList.add(new Crew(Course.getCourseByString(infoStringList.get(0)), shuffledCrew.get(i + 1)));
				crewList.add(new Crew(Course.getCourseByString(infoStringList.get(0)), shuffledCrew.get(i + 2)));
				break;
			}
			crewList.add(new Crew(Course.getCourseByString(infoStringList.get(0)), shuffledCrew.get(i)));
			crewList.add(new Crew(Course.getCourseByString(infoStringList.get(0)), shuffledCrew.get(i + 1)));
		}
	}

	public String getLevel() {
		return level;
	}

	public String getMission() {
		return mission;
	}

	public List<Crew> getCrewList() {
		return crewList;
	}

	private void validatePairMatching(List<String> crewNames) {

	}

	private void validateMatchingInfo(String matchingInfoString, Levels levels) {
		try {
			isValidMatchingInfoString(matchingInfoString);
			List<String> infoStringList = Arrays.asList(matchingInfoString.split(", "));
			isValidCourseInfo(infoStringList);
			isValidLevelInfo(infoStringList, levels);
			isValidMissionInfo(infoStringList, levels);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private void isValidCourseInfo(List<String> matchingInfoString) {
		String courseString = matchingInfoString.get(0);
		if (!(courseString.equals("백엔드") || courseString.equals("프론트엔드"))) {
			throw new IllegalArgumentException(ExceptionMessages.ERROR_PREFIX + "과정은 백엔드 혹은 프론트엔드만 있습니다.");
		}
	}

	private void isValidLevelInfo(List<String> matchingInfoString, Levels levels) {
		String levelString = matchingInfoString.get(1);
		if (!levels.isValidLevel(levelString)) {
			throw new IllegalArgumentException(ExceptionMessages.ERROR_PREFIX + "레벨은 1~5까지만 있습니다.");
		}
	}

	private void isValidMissionInfo(List<String> matchingInfoString, Levels levels) {
		String missionString = matchingInfoString.get(2);
		if (!levels.isValidMission(missionString)) {
			throw new IllegalArgumentException(ExceptionMessages.ERROR_PREFIX + "잘못된 미션 입력입니다.");
		}
	}

	private void isValidMatchingInfoString(String matchingInfoString) {
		String regex = "[가-힣]+,\\s[가-힣0-9]+,\\s[가-힣]+";
		if (!matchingInfoString.matches(regex)) {
			throw new IllegalArgumentException(ExceptionMessages.ERROR_PREFIX + "잘못된 입력 양식입니다.");
		}
	}
}
