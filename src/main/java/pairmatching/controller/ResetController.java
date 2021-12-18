package pairmatching.controller;

import pairmatching.resource.PairMachMap;

public class ResetController {
	private static final ResetController resetController = new ResetController();

	private PairMachMap pairMachMap;

	private ResetController() {
		pairMachMap = PairMachMap.getInstance();
	}

	public static ResetController getInstance() {
		return resetController;
	}

	public void run() {
		pairMachMap.resetMap();
	}
}
