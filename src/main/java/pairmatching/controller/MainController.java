package pairmatching.controller;

import pairmatching.view.ViewController;

public class MainController {
	private static final MainController mainController = new MainController();

	private final ViewController viewController;

	private MainController() {
		viewController = ViewController.getInstance();
	}

	public static MainController getInstance() {
		return mainController;
	}

	public void run() {
		System.out.println(viewController.getFunctionSelection());
	}
}
