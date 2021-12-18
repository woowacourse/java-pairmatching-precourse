package pairmatching.controller;

import pairmatching.serivce.PairMatching;

public class PairMatchingController {
	private PairMatching pairMatching;

	public PairMatchingController(PairMatching pairMatching) {
		this.pairMatching = pairMatching;
	}

	public void start() {
		readCrews();
	}

	private void readCrews() {
		pairMatching.setCrews();
	}
}
