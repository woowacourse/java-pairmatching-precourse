package pairmatching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.MatchObjective;
import pairmatching.domain.Mission;
import pairmatching.exception.MatchFailException;
import pairmatching.service.CrewService;
import pairmatching.service.MatcherService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatcherController {

	private MatcherService matcherService;
	private CrewService crewService;
	private Map<Course, Map<Level, Map<String, Mission>>> missionMap;

	public MatcherController() {
		this.matcherService = new MatcherService();
		this.crewService = new CrewService();
		this.missionMap = new HashMap<>();
		for (Course course : Course.values()) {
			Map<Level, Map<String, Mission>> map = new HashMap<>();
			for(Level level : Level.values()){
				map.put(level, new HashMap<>());
			}
			missionMap.put(course, map);
		}
	}

	public MatchObjective requestMatchInfo() {
		String input = InputView.inputMatchInfo();
		List<String> infoList = Arrays.asList(input.split(", ", -1));
		return new MatchObjective(Course.ofName(infoList.get(0)), Level.ofName(infoList.get(1)), infoList.get(2));
	}

	public String requestFunctionNumber() {
		return InputView.inputFunctionNumber();
	}

	public Mission match(MatchObjective matchObjective) {
		try {
			Mission mission = matcherService.match(matchObjective, 0);
			saveMission(mission);
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
			MatchObjective matchObjective = requestMatchInfo();
			printMission(matchObjective);
			return true;
		}
		return false;
	}

	public void operate() {
		while (operateLoop())
			;
	}

	public void saveMission(Mission mission) {
		Map<Level, Map<String, Mission>> mapCourse = missionMap.get(mission.getCourse());
		Map<String, Mission> map = mapCourse.get(mission.getLevel());
		map.put(mission.getName(), mission);
	}

	public void printMission(MatchObjective matchObjective) {
		Mission mission = missionMap.get(matchObjective.getCourse()).get(matchObjective.getLevel()).get(matchObjective.getMission());
		OutputView.printMatchInfo(mission);
	}
}
