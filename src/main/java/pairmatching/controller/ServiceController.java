package pairmatching.controller;

import java.util.ArrayList;

import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class ServiceController {
	public static ArrayList<Mission> missions;
	static String choice = "";
	static String[] matchingInfo;

	public static void run() {
		generateMission();
		while (!(choice.equals("Q"))) {
			askFunction();
			if (choice.equals("1")) {
				doMatching();
			}// } else if (choice.equals("2")) {
			//
			// } else if (choice.equals("3")) {
			//
			// }
		}
	}


	private static void doMatching() {
		askMatchingInfo();
		MatchingController.doMatching(matchingInfo);
		OutputView.showMatchingResult();
	}

	private static void generateMission() {
		missions = new ArrayList<>();
		missions.add(new Mission(Level.LEVEL1, "자동차경주"));
		missions.add(new Mission(Level.LEVEL1, "로또"));
		missions.add(new Mission(Level.LEVEL1, "숫자야구게임"));
		missions.add(new Mission(Level.LEVEL2, "장바구니"));
		missions.add(new Mission(Level.LEVEL2, "결제"));
		missions.add(new Mission(Level.LEVEL2, "지하철노선도"));
		missions.add(new Mission(Level.LEVEL4, "성능개선"));
		missions.add(new Mission(Level.LEVEL4, "배포"));
	}

	private static void askFunction() {
		OutputView.askFunction();
		try {
			choice = InputView.askFunction();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			askFunction();
		}
	}

	private static void askMatchingInfo() {
		OutputView.askMatchingInfo();
		try {
			matchingInfo = InputView.askMatchingInfo();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			askMatchingInfo();
		}
	}
}
