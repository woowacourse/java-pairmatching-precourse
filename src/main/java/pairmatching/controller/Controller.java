package pairmatching.controller;

import static pairmatching.domain.Crews.*;
import static pairmatching.domain.Missions.*;


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
	public void play() {
		InitService.initCrew();
		InitService.initMission();
		while (true){
			String mainOption = InputView.selectFunction();
			if (mainOption.equals("1")) {
				matchingPair();
			} else if (mainOption.equals("2")) {

			} else if (mainOption.equals("3")) {

			} else if (mainOption.equals("Q")) {
				break;
			}
		}
	}

	public void matchingPair() {
		String missionInformation = InputView.inputMission();
		String[] splitInformation = missionInformation.split(",");
		Course course = Course.mappingStringValue(splitInformation[0].trim());
		Level level = Level.mappingStringValue(splitInformation[1].trim());
		List<Crew> crewList = getCrewList(course);
		List<Mission> missionList = getMissionList(level);
		Mission mission = getMission(level, splitInformation[2].trim());
		List<Pair> pair = Pairs.createPair(crewList, mission);
		OutputView.alarmPairMatchingResult();
		for (Pair pair1 : pair) {
			OutputView.showPairMatchingResult(pair1.getCrews());
		}
	}
}
