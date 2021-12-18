package pairmatching.service;

import pairmatching.domain.Pair;

public class PairMatchingService {

	private Pair pair;

	public PairMatchingService() {
		this.pair = new Pair();
	}

	public boolean selectFunction(String input) {
		//TODO: validation

		// 1, 2, 3, Q로 입력 받아서 처리
		return pair.handleFunction(input);
	}

	public void selectProcessLevelMission(String input) {

	}
}
