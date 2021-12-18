package pairmatching.controller;

import java.util.List;

import pairmatching.view.InputView;

public class PairMatchingController {
	private static List<String> backEndCrewNames;
	private static List<String> frontEndCrewNames;
	private InputView inputView;


	public PairMatchingController() {
		inputView = new InputView();
	}


	public void init() {
		backEndCrewNames = inputView.getBackEndCrewNames();
		frontEndCrewNames = inputView.getFrontEndCrewNames();
	}
}
