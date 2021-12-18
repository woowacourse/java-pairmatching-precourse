package pairmatching.controller;

import java.util.List;

import pairmatching.resource.PairMachMap;
import pairmatching.view.ViewController;

public class PairMachController {
	private static final PairMachController pairMachController = new PairMachController();

	private final ViewController viewController;
	private final PairMachMap pairMachMap;

	private PairMachController() {
		viewController = ViewController.getInstance();
		pairMachMap = PairMachMap.getInstance();
	}

	public static PairMachController getInstance() {
		return pairMachController;
	}

	public void run(){
		List<String> targetSelection = viewController.getTargetSelection();
		pairMachMap.createPair(targetSelection);
	}
}
