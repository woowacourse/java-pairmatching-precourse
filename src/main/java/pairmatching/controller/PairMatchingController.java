package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Levels;
import pairmatching.model.Mission;
import pairmatching.view.InputView;

public class PairMatchingController {
	private static List<String> backEndCrewNames;
	private static List<String> frontEndCrewNames;
	private InputView inputView;

	public PairMatchingController() {
		inputView = new InputView();
	}

	public void init() {
		backEndCrewNames = inputView.getBackEndCrewNames();
		frontEndCrewNames = inputView.getFrontEndCrewNames();

	}

	private void initCourse() {
		Course backendCourse = Course.BACKEND;
		Course frontendCourse = Course.FRONTEND;
	}

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
		Levels levels = new Levels(levelList);
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
