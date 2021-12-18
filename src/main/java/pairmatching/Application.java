package pairmatching;

import static pairmatching.utils.Constant.*;

import pairmatching.controller.MainController;

public class Application {
	public static void main(String[] args) {
		// TODO 구현 진행
		MainController pairMatching = new MainController();
		String run = START;
		while (run.equals(AGAIN)) {
			run = pairMatching.run();
		}
	}
}
