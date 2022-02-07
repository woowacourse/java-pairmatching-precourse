package pairmatching.controller;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pairs;
import pairmatching.domain.repository.Repository;
import pairmatching.view.OutputView;

public class PairMatchingController {
	public static final String NO = "아니오";

	public PairMatchingController() {
		start();
	}

	private void start() {
		// 작동 시작
		String mainInput = InputController.getMain();
		if (mainInput.equals("Q")) {
			return;
		}
		if (mainInput.equals("1")) {
			pairMatch();
		}
		if (mainInput.equals("2")) {
			pairSearch();
		}
		if (mainInput.equals("3")) {
			pairReset();
		}
		start();
	}

	private void pairMatch() {
		String[] input = InputController.getPairMatch();
		String end = input[0];
		Mission mission = Repository.levelsFind(input[1]).findMission(input[2]);

		if (!mission.isEmpty(end) && InputController.getRePairMatch().equals(NO)) {
			return;
		}
		mission.setPairs(end, new Pairs(Repository.getBranchList(end)));
		OutputView.printPairs(mission.getPairs(end));
	}

	private void pairSearch() {
		String[] input = InputController.getPairMatch();
		String end = input[0];
		Mission mission = Repository.levelsFind(input[1]).findMission(input[2]);

		OutputView.printPairs(mission.getPairs(end));
	}

	private void pairReset() {
		Repository.levels.forEach(Level::reset);
		OutputView.printReset();
	}

}
