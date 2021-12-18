package pairmatching;

import pairmatching.controller.CrewController;
import pairmatching.controller.MatchingController;
import pairmatching.exception.QuitProgramException;

public class Application {
	private static final CrewController crewController = new CrewController();
	private static final MatchingController matchingController = new MatchingController();

	public static void main(String[] args) {
		try {
			matchingController.getFunctionNumber();
		} catch (QuitProgramException ignored) {
			// 프로그램 종료
		}
	}
}
