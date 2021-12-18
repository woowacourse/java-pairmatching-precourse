package pairmatching.exception;

import pairmatching.domain.unit.Course;
import pairmatching.domain.unit.Level;
import pairmatching.domain.unit.Mission;

public class GlobalException {
	private static final int COURSE = 0;
	private static final int LEVEL = 1;
	private static final int MISSION = 2;

	private static final String NOT_CORRECT_INFORMATION_ERROR = "과정, 미션, 레벨 명을 확인해주세요.";

	public static void validateMatchingInformation(String[] information) {
		String course = information[COURSE];
		String level = information[LEVEL];
		String mission = information[MISSION];

		isCourse(course);
		isLevel(level);
		isMission(mission);
	}

	private static void isCourse(String course) {
		boolean check = false;

		if(course.equals("백엔드") || course.equals("프론트엔드")) {
			check = true;
		}

		check(check);
	}

	private static void isLevel(String level) {
		boolean check = false;
		for(Level rightLevel : Level.values()) {
			if(level.equals(rightLevel.getName())) {
				check = true;
			}
		}

		check(check);
	}

	private static void isMission(String mission) {
		boolean check = false;
		for(Mission rightMission : Mission.values()) {
			if(mission.equals(rightMission.getName())) {
				check = true;
			}
		}

		check(check);
	}

	private static void check(boolean check) {
		if(!check) {
			throw new IllegalArgumentException(NOT_CORRECT_INFORMATION_ERROR);
		}
	}

}
