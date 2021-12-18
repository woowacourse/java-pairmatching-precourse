package pairmatching.Controller;

import pairmatching.Model.menu.MainMenu;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController implements Controller {
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	MainMenu mainMenu;

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


	public static void resetPair() {
		System.out.println("resetPair");
	}
}
