package pairmatching.controller;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.Mission;
import pairmatching.exception.MatchFailException;
import pairmatching.service.CrewService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatcherController {

	private final Map<Course, CrewService> crewServiceMap;
	private Map<Course, Map<Level, Map<String, Mission>>> missionMap;

	public MatcherController() {
		this.crewServiceMap = new EnumMap<>(Course.class);
		Arrays.stream(Course.values()).forEach(course -> crewServiceMap.put(course, new CrewService(course)));

		this.missionMap = new HashMap<>();
		for (Course course : Course.values()) {
			Map<Level, Map<String, Mission>> map = new HashMap<>();
			for (Level level : Level.values()) {
				map.put(level, new HashMap<>());
			}
			missionMap.put(course, map);
		}
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
			Mission mission = requestMatchInfo();
			printMission(mission);
			return true;
		}
		return false;
	}

	public void operate() {
		while (operateLoop()) {
		}
	}

	public void saveMission(Mission mission) {
		Map<Level, Map<String, Mission>> mapCourse = missionMap.get(mission.getCourse());
		Map<String, Mission> map = mapCourse.get(mission.getLevel());
		map.put(mission.getName(), mission);
	}

	public Optional<Mission> findMission(Mission mission) {
		return Optional.ofNullable(missionMap.get(mission.getCourse()).get(mission.getLevel()).get(mission.getName()));
	}

	public void printMission(Mission mission) {
		Mission result = findMission(mission).orElseThrow(
			() -> new IllegalArgumentException("[ERROR] " + "해당 매칭이 없습니다"));
		OutputView.printMatchInfo(result);
	}
}
