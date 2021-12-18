package pairmatching.controller;

import pairmatching.domain.TechCourse;

public class PairMatchingController {
	public void run() {
		TechCourse techCourse = new TechCourse();

		while (true) {
			OutputView.mainPage();
			String mainCommend = getMainCommend();
			if (mainCommend.equals("1")) {
				matchPair();
			}
			if (mainCommend.equals("2")) {
				lookUpPair();
			}
			if (mainCommend.equals("3")) {
				resetPair();
			}
			if (mainCommend.equals("Q")) {
				return;
			}
		}
	}
}
