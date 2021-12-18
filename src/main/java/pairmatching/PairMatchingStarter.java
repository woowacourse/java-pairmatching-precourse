package pairmatching;

import pairmatching.controller.PairMatchingController;

public class PairMatchingStarter {

	private PairMatchingController pairMatchingController;

	public PairMatchingStarter() {
		this.pairMatchingController = new PairMatchingController();
	}

	public void start() {

		while(true) {
			boolean check = pairMatchingController.selectFunction();
			if(check) {
				pairMatchingController.selectProcessLevelMission();
			}

			if(!check) {
				break;
			}
		}
	}
}
