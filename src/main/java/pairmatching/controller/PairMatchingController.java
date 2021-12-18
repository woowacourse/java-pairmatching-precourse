package pairmatching.controller;

import pairmatching.model.PairMatching;
import pairmatching.service.MakingShuffleList;
import pairmatching.service.SelectingOptionService;
import pairmatching.view.PairMatchingView;
import pairmatching.view.UserView;

public class PairMatchingController {
	public PairMatching pairMatching;
	public PairMatchingView pairMatchingView;
	public UserView userView;
	public SelectingOptionService selectingOptionService;

	public PairMatchingController() {
		pairMatching = new PairMatching();
		pairMatchingView = new PairMatchingView();
		userView = new UserView();
		selectingOptionService = new SelectingOptionService(pairMatchingView, userView);
	}

	public void use() {
		while (true) {
			pairMatchingView.selectOptionToDO();
			String option = userView.selectOptionToDo();

			if (option.equals("Q"))
				return;

			if (option.equals("1")) {
				pairMatchingView.selectCourseLevelMission();
				try {
					MakingShuffleList.printPairList(pairMatching.makePair(userView.selectCourseLevelMission()));
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}

			if (option.equals("2")) {
				pairMatchingView.selectCourseLevelMission();

				if (!pairMatching.findPair(userView.selectCourseLevelMission())) {
					System.out.println("[ERROR]");
				}
				;
			}

			if (option.equals("3")) {
				pairMatching.missionInfoSet.clear();
				System.out.println("\n초기화 되었습니다.\n");
			}

		}
	}

}
