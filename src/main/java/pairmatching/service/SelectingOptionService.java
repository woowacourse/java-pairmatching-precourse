package pairmatching.service;

import pairmatching.view.PairMatchingView;
import pairmatching.view.UserView;

public class SelectingOptionService {
	public void selectOption(PairMatchingView pairMatchingView, UserView userView) {
		pairMatchingView.selectOptionToDO();
		String option = userView.selectOptionToDO();
	}
}
