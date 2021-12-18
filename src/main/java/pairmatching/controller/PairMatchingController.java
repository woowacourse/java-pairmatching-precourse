package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Pair;
import pairmatching.util.Constants;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private List<String> shuffledCrew;
	private final List<Pair> pairs = new ArrayList<>();
	private int trial = 0;

	public PairMatchingController() {
	}

	public void run() {
		ProcessController processController = new ProcessController();
		do {
			List<String> process = processController.input();
			shuffledCrew = CrewController.shuffle();
			Level curLevel = getCurLevel(process);
			generatePair(curLevel);
			OutputView.printMatchingResult(pairs);
		} while (!validate());
	}

	private Level getCurLevel(List<String> process) {
		for (Level level : Level.values()) {
			if (level.getName().equals(process.get(1))) {
				return level;
			}
		}
		return null;
	}

	private boolean validate() {
		return false;
	}

	private void generatePair(Level curLevel) {
		do {
			int listSize = shuffledCrew.size();
			Pair pair = new Pair();
			for (int i = 0; i < listSize; i += 2) {
				pair.addCrew(new Crew(shuffledCrew.get(i)));
				pair.addCrew(new Crew(shuffledCrew.get(i+1)));
				pairs.add(pair);
			}
			if (listSize % 2 != 0) {
				pair.addCrew(new Crew(shuffledCrew.get(listSize - 1)));
			}
			pairs.add(pair);
		} while (checkPairInPast(pairs, curLevel));
	}

	private boolean checkPairInPast(List<Pair> pairsToCheck, Level curLevel) {
		for (Pair pair : pairsToCheck) {
			if (curLevel.checkPairInPast(pair)) {
				addTrial();
				pairs.clear();
				return true;
			}
		}
		return false;
	}

	private void addTrial() {
		trial++;
		if (trial == Constants.PAIR_MATCHING_TRIAL_MAX_VALUE) {
			System.out.println(Constants.ERROR_MESSAGE_IMPOSSIBLE_PAIR_MATCHING);
			throw new IllegalArgumentException();
		}
	}

	public void printPairs() {
		OutputView.printMatchingResult(pairs);
	}

	public void removePairs() {
		OutputView.printInitialization();
		pairs.clear();
	}
}
