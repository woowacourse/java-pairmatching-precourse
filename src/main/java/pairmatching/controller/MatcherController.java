package pairmatching.controller;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import pairmatching.constant.Course;
import pairmatching.domain.Mission;
import pairmatching.exception.MatchFailException;
import pairmatching.service.CrewService;
import pairmatching.service.MissionService;
import pairmatching.util.CrewReadUtils;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatcherController {

	public static final String FUNCTION_PAIR_MATCH = "1";
	public static final String FUNCTION_FIND_MATCHING = "2";
	public static final String FUNCTION_CLEAR_MATCHING = "3";

	private final Map<Course, CrewService> crewServiceMap;
	private final Map<Course, MissionService> missionServiceMap;

	public MatcherController() {
		this.crewServiceMap = new EnumMap<>(Course.class);
		Arrays.stream(Course.values())
			.forEach(course -> crewServiceMap.put(course, new CrewService(CrewReadUtils.readCrews(course))));

		this.missionServiceMap = new EnumMap<>(Course.class);
		Arrays.stream(Course.values()).forEach(course -> missionServiceMap.put(course, new MissionService()));
	}

	public Mission requestMatchInfo() {
		try {
			return InputView.inputMatchRequest();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return requestMatchInfo();
		}
	}

	public String requestFunctionNumber() {
		return InputView.inputFunctionNumber();
	}

	public Mission match(Mission mission) {
		try {
			saveMission(crewServiceMap.get(mission.getCourse()).match(mission, 0));
			return mission;
		} catch (MatchFailException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean operateLoop() {
		String input = requestFunctionNumber();
		if (input.equals(FUNCTION_PAIR_MATCH)) {
			Mission mission = match(requestMatchInfo());
			if (mission != null)
				OutputView.printMatchInfo(mission);
			return true;
		}
		if (input.equals(FUNCTION_FIND_MATCHING)) {
			printMission(getMission());
			return true;
		}
		if (input.equals(FUNCTION_CLEAR_MATCHING)) {
			clearMatching();
			return true;
		}
		return false;
	}

	public void operate() {
		while (operateLoop()) {
		}
	}

	public void saveMission(Mission mission) {
		missionServiceMap.get(mission.getCourse())
			.save(mission);
	}

	public Mission getMission() {
		try {
			Mission missionRequest = requestMatchInfo();
			return missionServiceMap.get(missionRequest.getCourse())
				.getMission(missionRequest);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getMission();
		}
	}

	public void clearMatching() {
		missionServiceMap.values().forEach(MissionService::clearMissions);
		crewServiceMap.values().forEach(CrewService::clearHistories);
		OutputView.printCleared();
	}

	public void printMission(Mission mission) {
		OutputView.printMatchInfo(mission);
	}
}
