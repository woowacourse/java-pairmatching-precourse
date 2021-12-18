package pairmatching.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.constant.CheckValidationCourseLevelMissionStatus;

public class CheckerValidationCourseLevelMissionInput {
	String input;
	List<String> courses = new ArrayList<>();
	Map<String, List<String>> levels = new HashMap<>();
	List<String> missions = new ArrayList<>();

	public CheckerValidationCourseLevelMissionInput(String input) {
		this.input = input;
		List<String> level1Missions = new ArrayList<>();
		level1Missions.add("자동차경주");
		level1Missions.add("로또");
		level1Missions.add("숫자야구게임");
		List<String> level2Missions = new ArrayList<>();
		level1Missions.add("장바구니");
		level1Missions.add("결제");
		level1Missions.add("지하철노선도");
		List<String> level4Missions = new ArrayList<>();
		level4Missions.add("성능개선");
		level4Missions.add("배포");
		levels.put("레벨1", level1Missions);
		levels.put("레벨2", level2Missions);
		levels.put("레벨4", level4Missions);
	}

	//TODO: Mission input exception
	public CheckValidationCourseLevelMissionStatus checkValidation() {
		String inputCourse = input.split(", ")[0];
		String inputLevel = input.split(", ")[1];
		String inputMission = input.split(", ")[2];
		if (!(inputCourse.equals("백엔드") || inputCourse.equals("프론트엔드"))) {
			return CheckValidationCourseLevelMissionStatus.INVALID_COURSE;
		}
		if (!levels.get(inputLevel).contains(inputMission)) {
			return CheckValidationCourseLevelMissionStatus.INVALID_LEVEL;
		}
		return CheckValidationCourseLevelMissionStatus.VALID;
	}
}
