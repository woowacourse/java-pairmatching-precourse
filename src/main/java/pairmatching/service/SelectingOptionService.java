package pairmatching.service;

import pairmatching.view.PairMatchingView;
import pairmatching.view.UserView;

public class SelectingOptionService {
	public PairMatchingView pairMatchingView;
	public UserView userView;

	public SelectingOptionService(PairMatchingView pairMatchingView, UserView userView) {
		this.pairMatchingView = pairMatchingView;
		this.userView = userView;
	}

	public void selectOption() {
		pairMatchingView.selectOptionToDO();
		String option = userView.selectSomething();
	}

	public void selectCourseLevelMission() {
		pairMatchingView.selectCourseLevelMission();
		String selection = userView.selectSomething();
	}
}
