package pairmatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Function;
import pairmatching.domain.SelectedMission;

public class PairMatchingController {
	private final Map<SelectedMission, List<Map<String, String>>> matchingList = new HashMap<>();

	public void run() {
		Function selectedFunction = requestFunctionSelect();
		run(selectedFunction);
	}

	private Function requestFunctionSelect() {
		return Input.requestToSelectFunction();
	}

	private void run(Function function) {
		if (function == Function.QUIT) {
			return;
		}
		if (function == Function.RESET) {
			return;
		}

		Printer.printMissions();
		runMatchingOrSelect(function);
	}

	private void runMatchingOrSelect(Function function) {
		SelectedMission mission = Input.requestToSelectMission();
		if (function == Function.MATCHING) {
			runMatching(mission);
		}
	}

	private void runMatching(SelectedMission mission) {
		if (isMatchingExist(mission)) {
			if (Input.requestMatchingAgain()) {
				matchingList.remove(mission);
			}
		}
		match(mission);
	}

	private void match(SelectedMission mission) {
		List<String> crew = mission.getCrews();
		shuffle(mission, crew);
	}

	private void shuffle(SelectedMission mission, List<String> crew) {
		crew = Randoms.shuffle(crew);
		if (!isMatchingAble(mission, crew)) {
			shuffle(mission, crew);
		}

		List<Map<String, String>> matchingMap = new ArrayList<HashMap<String, String>>;
		for (int i = 0; i < crew.size(); i += 2) {
			Map<String, String> map = new HashMap<>();
			map.put(crew.get(i), crew.get(i + 1));
			map.put(crew.get(i + 1), crew.get(i));
			matchingMap.add(map);
		}
		matchingList.put(mission, matchingMap);
	}

	private boolean isMatchingExist(SelectedMission mission) {
		return matchingList.containsKey(mission);
	}

	private boolean isMatchingAble(SelectedMission mission, List<String> crew) {
		return matchingList.keySet()
			.stream()
			.filter(k -> k.isSameLevel(mission))
			.map(matchingList::get)
			.anyMatch(e -> isSameMatchContains(e, crew));
	}

	private boolean isSameMatchContains(List<Map<String, String>> target, List<String> subject) {
		for (int i = 0; i < subject.size(); i += 2) {
			String crewA = subject.get(i);
			String crewB = subject.get(i + 1);
			if (target.stream().anyMatch(map -> map.get(crewA).equals(crewB))) {
				return false;
			}
		}
		return true;
	}

}
