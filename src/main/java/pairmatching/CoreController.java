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
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;
	private static final int MATCH_PAIR_MAXIMUM_TRY_NUM = 3;
	private static final String BACKEND = "백엔드";
	private static final String FRONTEND = "프론트엔드";
	private static final String BACKEND_FILE_NAME = "backend-crew.md";
	private static final String FRONTEND_FILE_NAME = "frontend-crew.md";
	private static final String BASE_DIRECTORY = "src/main/resources/";
	private static final String TERMINATE = "Q";
	private static final String PAIR_MATCH = "1";
	private static final String PAIR_SEARCH = "2";
	private static final String PAIR_INIT = "3";
	private static final String NAME_IN_PAIR_SEPARATOR = " : ";

	private UiLogic uiLogic;
	private Map<String, List<String>> missionInLevel;
	private Map<String, Map<String, List<String>>> pairInMission;
	private Map<String, People> members;

	CoreController() {
		uiLogic = new UiLogic();
		init();
	}

	private void init() {
		missionInLevel = new HashMap<>();
		for (Level specificLevel : Level.values()) {
			String level = specificLevel.getName();
			missionInLevel.put(level, new ArrayList<>());
		}
		fillMission();
		pairInMission = new HashMap<>();
		pairInMission.put(BACKEND, new HashMap<>());
		pairInMission.put(FRONTEND, new HashMap<>());
		members = new HashMap<>();
		initMembers();
	}

	private void initMembers() {
		List<String> backendMembers = getPeopleInCourse(BACKEND);
		List<String> frontendMembers = getPeopleInCourse(FRONTEND);

		for (String name : backendMembers) {
			members.put(name, new People(name));
		}
		for (String name : frontendMembers) {
			members.put(name, new People(name));
		}
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
		checkCourseValid(courseLevelMission.get(COURSE_INDEX));
		checkLevelValid(courseLevelMission.get(LEVEL_INDEX));
		checkMissionValid(courseLevelMission.get(LEVEL_INDEX), courseLevelMission.get(MISSION_INDEX));
	}

	private ArrayList<String> getCourseLevelMission() {
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

	private ArrayList<String> getPeopleInCourse(String course) {
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

	private void eraseRecordInPair(String level, List<String> pairMembers) {
		for (String name : pairMembers) {
			for (String partnerName : pairMembers) {
				members.get(name).removeRecord(partnerName, level);
			}
		}
	}

	private void erasePeoPleWorkAlreadyRecord(String course, String level, String mission) {
		List<String> pairs = pairInMission.get(course).get(mission);
		for (String pair : pairs) {
			List<String> pairMembers = new ArrayList<>(Arrays.asList(pair.split(NAME_IN_PAIR_SEPARATOR)));
			eraseRecordInPair(level, pairMembers);
		}
	}

	private boolean checkRematch(String course, String level, String mission) {
		boolean isRematch = false;
		while (true) {
			try {
				isRematch = uiLogic.printRematchQuestion();
				break;
			} catch (IllegalArgumentException e) {
				uiLogic.printRematchQuestionErrorMessage();
			}
		}
		if (isRematch) {
			erasePeoPleWorkAlreadyRecord(course, level, mission);
		}
		return isRematch;
	}

	private void showPair(String course, String missionName) {
		List<String> pair = null;
		if (pairInMission.get(course).containsKey(missionName)) {
			pair = pairInMission.get(course).get(missionName);
		}
		uiLogic.printPair(pair);
	}

	private boolean checkAvailableMakePair(String level, String crewOneName, String crewTwoName) {
		People crewOne = members.get(crewOneName);
		People crewTwo = members.get(crewTwoName);
		if (crewOne.checkAlreadyWorkInLevel(crewTwoName, level)) {
			return false;
		}
		crewOne.recordPeoPleWorkInLevel(crewTwoName, level);
		crewTwo.recordPeoPleWorkInLevel(crewOneName, level);
		return true;
	}

	private List<String> getPair(String level, List<String> shuffledPeople) {
		List<String> pair = new ArrayList<>();
		for (int i = 1; i < shuffledPeople.size(); i += 2) {
			if (Boolean.FALSE.equals(checkAvailableMakePair(level, shuffledPeople.get(i - 1), shuffledPeople.get(i)))) {
				return null;
			}
			pair.add(shuffledPeople.get(i - 1) + NAME_IN_PAIR_SEPARATOR + shuffledPeople.get(i));
		}
		if (shuffledPeople.size() % 2 == 1) {
			String threePeoplePair =
				pair.get(pair.size() - 1) + NAME_IN_PAIR_SEPARATOR + shuffledPeople.get(pair.size() - 1);
			pair.set(pair.size() - 1, threePeoplePair);
		}
		return pair;
	}

	private List<String> makePair(String level, List<String> peopleNames) {
		for (int i = 0; i < MATCH_PAIR_MAXIMUM_TRY_NUM; ++i) {
			List<String> shuffledPeople = camp.nextstep.edu.missionutils.Randoms.shuffle(peopleNames);
			List<String> pair = getPair(level, shuffledPeople);
			if (pair != null) {
				return pair;
			}
		}
		return null;
	}

	private void matchPair(String course, String level, String mission) {
		ArrayList<String> peopleNames = getPeopleInCourse(course);
		if (pairInMission.get(course).containsKey(mission) && Boolean.FALSE.equals(
			checkRematch(course, level, mission))) {
			return;
		}
		List<String> pair = makePair(level, peopleNames);
		if (pair == null) {
			uiLogic.printFailPairErrorMessage();
			return;
		}
		pairInMission.get(course).put(mission, pair);
		showPair(course, mission);
	}

	private void searchPair(String course, String mission) {
		showPair(course, mission);
	}

	private void initAllPair() {
		init();
		uiLogic.printInitMessage();
	}

	private void activateAccordingMenuIndex(String menuIndex) {
		if (menuIndex.equals(PAIR_MATCH)) {
			ArrayList<String> courseLevelMission = getCourseLevelMission();
			matchPair(courseLevelMission.get(COURSE_INDEX), courseLevelMission.get(LEVEL_INDEX),
				courseLevelMission.get(MISSION_INDEX));
		}
		if (menuIndex.equals(PAIR_SEARCH)) {
			ArrayList<String> courseLevelMission = getCourseLevelMission();
			searchPair(courseLevelMission.get(COURSE_INDEX), courseLevelMission.get(MISSION_INDEX));
		}
		if (menuIndex.equals(PAIR_INIT)) {
			initAllPair();
		}
	}

	protected void run() {
		String menuIndex = "";
		while (Boolean.FALSE.equals(menuIndex.equals(TERMINATE))) {
			menuIndex = uiLogic.printMenu();

			activateAccordingMenuIndex(menuIndex);
		}
	}
}
