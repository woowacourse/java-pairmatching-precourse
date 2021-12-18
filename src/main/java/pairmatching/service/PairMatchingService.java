package pairmatching.service;

import pairmatching.domain.Pair;
import pairmatching.view.OutputView;

public class PairMatchingService {

	private Pair pair;

	public boolean selectFunction(String input) {
		//TODO: validation

		// 1, 2, 3, Q로 입력 받아서 처리
		if(input.equals("Q")) {
			return false;
		}

		pair = new Pair(Integer.parseInt(input));

		return true;
	}

	public void selectProcessLevelMission(String input) {

	}
}
