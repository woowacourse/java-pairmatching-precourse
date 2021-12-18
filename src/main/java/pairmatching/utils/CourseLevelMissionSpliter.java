package pairmatching.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CourseLevelMissionSpliter {
	public static final String DELIMETER = ",";
	public static final int LEGAL_SIZE = 3;

	public static List<String> split(String courseLevelMission) {
		String[] splitString = courseLevelMission.split(DELIMETER);
		List<String> courseLevelAndMission = Arrays.stream(splitString).map(s -> s.trim()).collect(Collectors.toList());
		if (courseLevelAndMission.size() != LEGAL_SIZE) {
			throw new IllegalArgumentException("올바르지 않은 입력입니다.");
		}
		return courseLevelAndMission;
	}
}
