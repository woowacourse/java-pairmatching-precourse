package pairmatching.model;

import java.util.Arrays;
import java.util.List;

import pairmatching.constants.Exceptions;

public class MatchingInfo {
	private Course course;
	private Level level;
	private Mission mission;
	private List<Crew> crewList;

	public MatchingInfo(String matchingInfoString) {
		validateMatchingInfo(matchingInfoString);
	}

	private void validateMatchingInfo(String matchingInfoString) {
		try {
			isValidMatchingInfoString(matchingInfoString);
			List<String> infoStringList = Arrays.asList(matchingInfoString.split(","));
			isValidCourseInfo(infoStringList);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private void isValidCourseInfo(List<String> matchingInfoString) {
		String courseString = matchingInfoString.get(0);
		if (!(courseString.equals("백엔드") || courseString.equals("프론트엔드"))) {
			throw new IllegalArgumentException(Exceptions.ERROR_PREFIX + "과정은 백엔드 혹은 프론트엔드만 있습니다.");
		}
	}

	private void isValidMatchingInfoString(String matchingInfoString) {
		String regex = "[가-힣]+,\\s[가-힣0-9]+,\\s[가-힣]+";
		if (!matchingInfoString.matches(regex)) {
			throw new IllegalArgumentException(Exceptions.ERROR_PREFIX + "잘못된 입력 양식입니다.");
		}
	}
}
