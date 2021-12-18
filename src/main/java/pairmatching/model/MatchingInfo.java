package pairmatching.model;

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
		String regex = "[가-힣]+,\\s[가-힣0-9]+,\\s[가-힣]+";
		if (!matchingInfoString.matches(regex)) {
			throw new IllegalArgumentException(Exceptions.ERROR_PREFIX + "잘못된 입력 양식입니다.");
		}
	}
}
