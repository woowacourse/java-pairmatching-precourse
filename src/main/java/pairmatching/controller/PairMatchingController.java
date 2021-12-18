package pairmatching.controller;

import pairmatching.serivce.PairMatching;
import pairmatching.type.PairMatchingType;
import pairmatching.type.InputType;

import static pairmatching.view.Input.*;
import static pairmatching.view.Print.*;

import java.util.HashMap;

public class PairMatchingController {
	private PairMatching pairMatching;

	public PairMatchingController(PairMatching pairMatching) {
		this.pairMatching = pairMatching;
	}

	private HashMap<String, String> setPairMatchingIntoHashMap(String stringOfPairMatching) {
		String[] parirMatchings = stringOfPairMatching.split(InputType.SPLIT.getString());

		HashMap<String, String> pairMatchingMap = new HashMap<>();
		pairMatchingMap.put("course", parirMatchings[0]);
		pairMatchingMap.put("level", parirMatchings[1]);
		pairMatchingMap.put("mission", parirMatchings[2]);

		return pairMatchingMap;
	}

	public void start() {
		readCrews();
		selectFunction();
	}

	private void readCrews() {
		pairMatching.setCrews();
	}

	private void selectFunction() {
		printSelectFunction();
		String input = inputFunction();
		if (input.equalsIgnoreCase(PairMatchingType.QUIT.getString())) {
			return;
		}

		int function = Integer.parseInt(input);
		if (function == PairMatchingType.MATCH.getNumber()) {
			pairMatching();
		} else if (function == PairMatchingType.VIEW.getNumber()) {
			// TODO: 조회
		} else if (function == PairMatchingType.RESET.getNumber()) {
			// TODO: 초기화
		}
		// selectFunction();
	}

	private void pairMatching() {
		printWoowaCourseInfo();

		String input = inputFunction();
		HashMap<String, String> pairMatchingMap = setPairMatchingIntoHashMap(input);
		if (!pairMatching.isAvailableMatch(pairMatchingMap)) {
			checkRematch(pairMatchingMap);
		}
		pairMatching.match(pairMatchingMap);
	}

	private void checkRematch(HashMap<String, String> pairMatchingMap) {
		printRematch();

		String input = inputRestart();
		if (input.equals(PairMatchingType.REMATCH.getString())) {
			pairMatching.match(pairMatchingMap);
			return;
		}
		selectFunction();
	}
}
