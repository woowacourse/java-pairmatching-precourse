package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Level;
import pairmatching.model.Levels;
import pairmatching.model.MatchingInfo;
import pairmatching.model.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private static List<String> backEndCrewNames;
	private static List<String> frontEndCrewNames;
	private static List<Crew> backendCrews;
	private static List<Crew> frontendCrews;
	private static List<MatchingInfo> matchingInfoList = new ArrayList<>();
	private static Levels levels;
	private InputView inputView;
	private OutputView outputView;

	public PairMatchingController() {
		inputView = new InputView();
		outputView = new OutputView();
	}

	public void init() {
		backEndCrewNames = inputView.getBackEndCrewNames();
		frontEndCrewNames = inputView.getFrontEndCrewNames();
		initCourse();
		initLevelAndMission();
	}

	public void run() {
		outputView.printChooseFeature();
		String featureNumber;
		boolean isContinue;
		do {
			featureNumber = inputView.inputChoosingFeature();
			isContinue = activateFeature(featureNumber);
		} while (isContinue);
	}

	public void matching() {
		MatchingInfo matchingInfo;
		try {
			outputView.printCourseAndMissionInfo(levels);
			String matchingInfoString = inputView.inputMatchingInfo();
			matchingInfo = new MatchingInfo(matchingInfoString, levels, backEndCrewNames,
				frontEndCrewNames);
			matchingInfoList.add(matchingInfo);
			outputView.printPairMatchingResult(matchingInfo);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			matching();
		}
	}

	private boolean activateFeature(String featureNumber) {
		String numberRegex = "[1-3]{1}";
		int number = getNumberByString(featureNumber, numberRegex);
		if (number == 1) {
			matching();
			return true;
		}
		if (number == 2) {
			printMatching();
			return true;
		}
		if (number == 3) {
			initializePair();
			return true;
		}
		return false;
	}

	private void initializePair() {
		matchingInfoList = new ArrayList<>();
	}

	private void printMatching() {
	}

	private int getNumberByString(String featureNumber, String numberRegex) {
		if (featureNumber.matches(numberRegex)) {
			int number = Integer.parseInt(featureNumber);
			return number;
		}
		return 4;
	}

	private void initCourse() {
		backendCrews = backEndCrewNames.stream()
			.map(crewString -> new Crew(Course.BACKEND, crewString.toString()))
			.collect(Collectors.toList());
		frontendCrews = frontEndCrewNames.stream()
			.map(crewString -> new Crew(Course.FRONTEND, crewString.toString()))
			.collect(Collectors.toList());
	}

	// private boolean isExistsPairInSameLevel(MatchingInfo matchingInfo) {
	// 	matchingInfoList.stream()
	// 		.filter(m -> m.getLevel().equals(matchingInfo.getLevel()))
	// 		.forEach(m -> m.getPairList().stream());
	// }

	private void initLevelAndMission() {
		List<Level> levelList = new ArrayList<>();
		List<Mission> missionsOne = getMissionsOne();
		List<Mission> missionsTwo = getMissionsTwo();
		List<Mission> missionsThree = getMissionsThree();
		List<Mission> missionsFour = getMissionsFour();
		List<Mission> missionsFive = getMissionsFive();
		Level levelOne = Level.LEVEL1;
		Level levelTwo = Level.LEVEL2;
		Level levelThree = Level.LEVEL3;
		Level levelFour = Level.LEVEL4;
		Level levelFive = Level.LEVEL5;
		levelOne.missionInit(missionsOne);
		levelTwo.missionInit(missionsTwo);
		levelThree.missionInit(missionsThree);
		levelFour.missionInit(missionsFour);
		levelFive.missionInit(missionsFive);
		levelList.add(levelOne);
		levelList.add(levelTwo);
		levelList.add(levelThree);
		levelList.add(levelFour);
		levelList.add(levelFive);
		levels = new Levels(levelList);
	}

	private List<Mission> getMissionsOne() {
		List<Mission> missionsOne = new ArrayList<>();
		missionsOne.add(new Mission("자동차경주"));
		missionsOne.add(new Mission("로또"));
		missionsOne.add(new Mission("숫자야구게임"));
		return missionsOne;
	}

	private List<Mission> getMissionsTwo() {
		List<Mission> missionsOne = new ArrayList<>();
		missionsOne.add(new Mission("장바구니"));
		missionsOne.add(new Mission("결제"));
		missionsOne.add(new Mission("지하철노선도"));
		return missionsOne;
	}

	private List<Mission> getMissionsThree() {
		List<Mission> missionsOne = new ArrayList<>();
		return missionsOne;
	}

	private List<Mission> getMissionsFour() {
		List<Mission> missionsOne = new ArrayList<>();
		missionsOne.add(new Mission("성능개선"));
		missionsOne.add(new Mission("배포"));
		return missionsOne;
	}

	private List<Mission> getMissionsFive() {
		List<Mission> missionsOne = new ArrayList<>();
		return missionsOne;
	}

}
