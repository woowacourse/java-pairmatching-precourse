package pairmatching.controller;

import pairmatching.repository.PairMap;
import pairmatching.view.PairView;

public class InitializationController {
	public static void initialize() {

		PairMap.initialize();

		PairView.printInitMessage();
	}
}
