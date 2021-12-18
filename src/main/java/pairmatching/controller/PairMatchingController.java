package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.model.Course;
import pairmatching.model.Mission;
import pairmatching.model.Pair;
import pairmatching.model.Pairs;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	public void run() {
		String selected = "";

		while (!selected.equals("Q")) {
			selected = InputView.selectFunction();
			List<Pair> pairList = new ArrayList<>();

			if (selected.equals("1")) {
				pairList = pairMatcing(selected, pairList);
			}

			if (selected.equals("2")) {
				pairList = pairMatcing(selected, pairList);
			}

			OutputView.printPairMatch(pairList);
		}
	}

	private List<Pair> pairMatcing(String selected, List<Pair> pairList) {
		OutputView.printMissions();
		Mission mission = InputView.askSelectOption();

		if (mission.getCourse().equals(Course.BACKEND)) {
			pairList = Pairs.backendPairMatch();
		}
		if (mission.getCourse().equals(Course.FRONTEND)) {
			pairList = Pairs.frontendPairMatch();
		}

		return pairList;
	}

}
