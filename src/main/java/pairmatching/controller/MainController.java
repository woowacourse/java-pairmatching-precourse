package pairmatching.controller;

import static pairmatching.constants.ProgramConstants.*;

import java.util.Objects;

import pairmatching.view.ViewController;

public class MainController {
	private static final MainController mainController = new MainController();

	private final ViewController viewController;
	private final PairMachController pairMachController;
	private final PairCheckController pairCheckController;
	private final ResetController resetController;

	private MainController() {
		viewController = ViewController.getInstance();
		pairMachController = PairMachController.getInstance();
		pairCheckController = PairCheckController.getInstance();
		resetController = ResetController.getInstance();
	}

	public static MainController getInstance() {
		return mainController;
	}

	public void run() {
		String userSelection = viewController.getFunctionSelection();
		runFunctionController(userSelection);
	}

	private void runFunctionController(String userSelection) {
		if (Objects.equals(userSelection, PAIR_MACH_SELECT)) {
			pairMachController.run();
		}
		if (Objects.equals(userSelection, PAIR_CHECK_SELECT)) {
			pairCheckController.run();
		}
		if (Objects.equals(userSelection, RESET_SELECT)) {
			resetController.run();
		}
	}
}
