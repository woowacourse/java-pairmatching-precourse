package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoreController {
	private static final int courseIndex = 0;
	private static final int levelIndex = 1;
	private static final int missionIndex = 2;
	private static final String BACKEND = "백엔드";
	private static final String BACKEND_FILE_NAME = "backend-crew.md";
	private static final String FRONTEND_FILE_NAME = "frontend-crew.md";
	private static final String BASE_DIRECTORY = "src/main/resources/";

	private UiLogic uiLogic;
	private Map<String, List<String>> missionInLevel;

	CoreController() {
		uiLogic = new UiLogic();
		missionInLevel = new HashMap<>();
		for (Level specificLevel : Level.values()) {
			String level = specificLevel.getName();
			missionInLevel.put(level, new ArrayList<>());
		}
		fillMission();
	}

	private void fillMission() {
		missionInLevel.put("레벨1", new ArrayList<>(Arrays.asList("자동차경주", "로또", "숫자야구게임")));
		missionInLevel.put("레벨2", new ArrayList<>(Arrays.asList("장바구니", "결제", "지하철노선도")));
		missionInLevel.put("레벨4", new ArrayList<>(Arrays.asList("성능개선", "배포")));
	}

	private void checkCourseValid(String course) throws IllegalArgumentException {
		for (Course specificCourse : Course.values()) {
			if (specificCourse.isSameName(course)) {
				return;
			}
		}
		throw new IllegalArgumentException();
	}

	private void checkLevelValid(String level) throws IllegalArgumentException {
		for (Level specificLevel : Level.values()) {
			if (specificLevel.isSameName(level)) {
				return;
			}
		}
		throw new IllegalArgumentException();
	}

	private void checkMissionValid(String level, String mission) throws IllegalArgumentException {
		List<String> missions = missionInLevel.get(level);
		if (Boolean.FALSE.equals(missions.contains(mission))) {
			throw new IllegalArgumentException();
		}
	}

	private void checkCourseLevelMissionValid(ArrayList<String> courseLevelMission) throws IllegalArgumentException {
		checkCourseValid(courseLevelMission.get(courseIndex));
		checkLevelValid(courseLevelMission.get(levelIndex));
		checkMissionValid(courseLevelMission.get(levelIndex), courseLevelMission.get(missionIndex));
	}

	protected ArrayList<String> getCourseLevelMission() {
		boolean endCondition = false;
		ArrayList<String> courseLevelMission = null;
		while (Boolean.FALSE.equals(endCondition)) {
			try {
				courseLevelMission = uiLogic.printCourseLevelMission();
				checkCourseLevelMissionValid(courseLevelMission);
				endCondition = true;
			} catch (IllegalArgumentException e) {
				uiLogic.printCourseLevelMissionErrorMessage();
			}
		}
		return courseLevelMission;
	}

	private String getFileName(String course) {
		if (course.equals(BACKEND)) {
			return BACKEND_FILE_NAME;
		}
		return FRONTEND_FILE_NAME;
	}

	protected ArrayList<String> getPeopleInCourse(String course) {
		ArrayList<String> peopleName = new ArrayList<>();
		String path = BASE_DIRECTORY + getFileName(course);

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String name;
			while ((name = reader.readLine()) != null) {
				peopleName.add(name);
			}
			reader.close();
		} catch (IOException e) {
			uiLogic.printFileReadError();
		}

		return peopleName;
	}
}
