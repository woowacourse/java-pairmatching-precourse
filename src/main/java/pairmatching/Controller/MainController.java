package pairmatching.Controller;

import pairmatching.Model.menu.MainMenu;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController implements Controller {
	private final InputView inputView;
	private final OutputView outputView;
	MainMenu mainMenu;

	public MainController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	@Override
	public void run() {
		do {
			mainMenu = selectMenu();
			start();

		} while (mainMenu.isRunning());

	}

	private MainMenu selectMenu() {
		while (true) {
			try {
				outputView.printMainMenu(MainMenu.list());
				return MainMenu.fineMenu(inputView.enterMainMenu());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				mainMenu.setRunningState();
			}
		}
	}

	private void start() {
		if (mainMenu.isRunning()) {
			mainMenu.start();
		}
	}

	public static void matchingPair() {
		System.out.println("matchingPair");
	}

	public static void inquiryPair() {
		System.out.println("inquiryPair");
	}

	public static void resetPair() {
		System.out.println("resetPair");
	}
}
