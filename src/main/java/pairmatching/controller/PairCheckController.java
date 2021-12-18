package pairmatching.controller;

import java.util.List;
import java.util.Objects;

import pairmatching.resource.PairMachMap;
import pairmatching.view.ViewController;

public class PairCheckController {
	private static final PairCheckController pairCheckController = new PairCheckController();

	private final ViewController viewController;
	private final PairMachMap pairMachMap;

	private PairCheckController() {
		viewController = ViewController.getInstance();
		pairMachMap = PairMachMap.getInstance();
	}

	public static PairCheckController getInstance() {
		return pairCheckController;
	}

	public void run() {
		List<String> targetSelection = viewController.getTargetSelection();
		pairMachMap.getPair(targetSelection);
	}
}
