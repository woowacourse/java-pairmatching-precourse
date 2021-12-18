package pairmatching.validator;

import java.util.Arrays;

import pairmatching.repository.CourseLevel;

public class PairMatchingValidator {
	CourseLevel courseLevel = new CourseLevel();

	public void isValidInput(String rawInfo) {
		if (!rawInfo.contains(", ")) {
			throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 형식: ");
		}
	}

	public void isValidInfo(String[] cleanInfo) {
		isValidLength(cleanInfo);
		isValidCourseName(cleanInfo[0]);
		isValidLevel(cleanInfo[1]);
		isValidMission(cleanInfo[1], cleanInfo[2]);
	}

	public void isValidLength(String[] cleanInfo) {
		if (cleanInfo.length != 3) {
			throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
		}
	}

	public void isValidCourseName(String courseName) {
		String[] validCourse = {"프론트엔드", "백엔드"};
		if (!Arrays.asList(validCourse).contains(courseName)) {
			throw new IllegalArgumentException("[ERROR] 없는 과정입니다.");
		}
		//
	}

	public void isValidLevel(String level) {
		String[] validLevel = {"레벨1", "레벨2", "레벨4"};
		if (!Arrays.asList(validLevel).contains(level)) {
			throw new IllegalArgumentException("[ERROR] 잘못된 레벨입니다.");
		}

	}

	public void isValidMission(String level, String mission) {
		if (level.equals("레벨1")) {
			isValidMissionLevel1(mission);
		}
		if (level.equals("레벨2")) {
			isValidMissionLevel2(mission);
		}
		if (level.equals("레벨4")) {
			isValidMissionLevel4(mission);
		}

	}

	public void isValidMissionLevel1(String mission) {
		if (!courseLevel.isMissionInLevel1(mission)) {
			throw new IllegalArgumentException("[ERROR] 없는 미션 입니다.");
		}

	}

	public void isValidMissionLevel2(String mission) {
		if (!courseLevel.isMissionInLevel2(mission)) {
			throw new IllegalArgumentException("[ERROR] 없는 미션 입니다.");
		}


	}

	public void isValidMissionLevel4(String mission) {
		if (!courseLevel.isMissionInLevel4(mission)) {
			throw new IllegalArgumentException("[ERROR] 없는 미션 입니다.");
		}

	}

}
