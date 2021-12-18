package pairmatching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.Function;
import pairmatching.domain.SelectedMission;

public class PairMatchingController {
	private final Map<SelectedMission, List<String>> matchingList = new HashMap<>();

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

	public void runMatching(SelectedMission mission) {
		if (isMatchingExist(mission)) {
			if (Input.requestMatchingAgain()) {
				matchingList.remove(mission);
			}
		}
		List<String> backendCrew = Input.readBackendCrewName();
		List<String> frontendCrew = Input.readFrontendCrewName();
	}

	public boolean isMatchingExist(SelectedMission mission) {
		return matchingList.containsKey(mission);
	}
}
