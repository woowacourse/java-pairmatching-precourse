package pairmatching.controller;

import static pairmatching.domain.Crews.*;
import static pairmatching.domain.Missions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.InitService;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
	private Mission mission;
	private List<Crew> crewList = new ArrayList<>();

	public void play() {
		setInitStatus();
		while (true) {
			String mainOption = InputView.selectFunction();
			if (mainOption.equals("1")) {
				matchingPair();
			} else if (mainOption.equals("2")) {
				showPair();
			} else if (mainOption.equals("3")) {
				initPair();
			} else if (mainOption.equals("Q")) {
				break;
			}
		}
	}

	public void matchingPair() {
		inputMissionWithErrorHandling();
		String pairRematching = "";
		if (Pairs.isContainPairing(mission)) {
			pairRematching = InputView.inputPairRematching().trim();
		}
		if (pairRematching.isEmpty() || pairRematching.equals("네")) {
			Pairs.createPair(crewList, mission);
		}
		OutputView.alarmPairMatchingResult();
		for (Pair pair1 : Pairs.getPairList(mission)) {
			OutputView.showPairMatchingResult(getCrewNames(pair1.getCrews()));
		}
	}

	public void showPair() {
		inputMissionWithErrorHandling();
		try {
			OutputView.alarmPairMatchingResult();
			for (Pair pair1 : Pairs.getPairList(mission)) {
				OutputView.showPairMatchingResult(getCrewNames(pair1.getCrews()));
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}

	}

	public void initPair() {
		Pairs.initializePairs();
		OutputView.initPair();
	}

	public void setInitStatus() {
		try {
			InitService.initCrew();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		InitService.initMission();
	}

	public void inputMissionWithErrorHandling() {
		try {
			String missionInformation = InputView.inputMission();
			String[] splitInformation = missionInformation.split(",");
			if (splitInformation.length < 3) {
				throw new IllegalArgumentException("[ERROR] 과정, 레벨, 미션을 다 입력해주셔야 한다.");
			}
			crewList = getCrewList(Course.mappingStringValue(splitInformation[0].trim()));
			Level level = Level.mappingStringValue(splitInformation[1].trim());
			List<Mission> missionList = getMissionList(level);
			mission = getMission(level, splitInformation[2].trim());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			inputMissionWithErrorHandling();
		}
	}
}
