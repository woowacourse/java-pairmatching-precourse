package pairmatching.controller;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.Mission;
import pairmatching.exception.MatchFailException;
import pairmatching.service.CrewService;
import pairmatching.service.MissionService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatcherController {

	private final Map<Course, CrewService> crewServiceMap;
	private final Map<Course, MissionService> missionServiceMap;

	public MatcherController() {
		this.crewServiceMap = new EnumMap<>(Course.class);
		Arrays.stream(Course.values()).forEach(course -> crewServiceMap.put(course, new CrewService(course)));

		this.missionServiceMap = new EnumMap<>(Course.class);
		Arrays.stream(Course.values()).forEach(course -> missionServiceMap.put(course, new MissionService()));
	}

	public Mission requestMatchInfo() {
		try {
			String input = InputView.inputMatchInfo();
			List<String> infoList = Arrays.asList(input.split(", ", -1));
			return new Mission(Course.ofName(infoList.get(0)), Level.ofName(infoList.get(1)), infoList.get(2));
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
			System.out.println("매칭에 실패했습니다. 메인으로 돌아갑니다.");
			return null;
		}
	}

	public boolean operateLoop() {
		String input = requestFunctionNumber();
		if (input.equals("1")) {
			Mission mission = match(requestMatchInfo());
			if (mission != null)
				OutputView.printMatchInfo(mission);
			return true;
		}
		if (input.equals("2")) {
			printMission(getMission());
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

	public void printMission(Mission mission) {
		OutputView.printMatchInfo(mission);
	}
}
