package pairmatching.controller;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import pairmatching.constant.Course;
import pairmatching.constant.ExceptionMessage;
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

	public boolean requestRematchOrNot() {
		return InputView.inputRematchOrNot();
	}

	public Mission match(Mission missionRequest) {
		if (findMission(missionRequest) != null && !requestRematchOrNot())
			return null;
		try {
			saveMission(crewServiceMap.get(missionRequest.getCourse()).match(missionRequest, 0));
			return missionRequest;
		} catch (MatchFailException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean operateLoop() {
		String input = requestFunctionNumber();
		if (input.equals(FUNCTION_PAIR_MATCH)) {
			Mission matchRequest = requestMatchInfo();
			Mission mission = match(matchRequest);
			OutputView.printMatchInfo(mission, ExceptionMessage.MATCHING_FAIL_FINALLY);
			return true;
		}
		if (input.equals(FUNCTION_FIND_MATCHING)) {
			printMission();
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
		missionServiceMap.get(mission.getCourse()).save(mission);
	}

	private Mission findMission(Mission missionRequest) {
		return missionServiceMap.get(missionRequest.getCourse()).getMission(missionRequest);
	}

	public void clearMatching() {
		missionServiceMap.values().forEach(MissionService::clearMissions);
		crewServiceMap.values().forEach(CrewService::clearHistories);
		OutputView.printCleared();
	}

	public void printMission() {
		try {
			Mission mission = findMission(requestMatchInfo());
			OutputView.printMatchInfo(mission, ExceptionMessage.MATCHING_NOT_FOUND);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			printMission();
		}

	}
}
