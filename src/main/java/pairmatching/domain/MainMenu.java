package pairmatching.domain;

import java.util.Arrays;

import pairmatching.controller.MainHandler;

public enum MainMenu {
	MATCHING_MANAGER("1", MainHandler::matchingManager),
	REFERENCE_MANAGER("2", MainHandler::referenceManager),
	INITIALIZATION_MANAGER("3", MainHandler::initializationManager),
	EXIT_MANGER("Q", MainHandler::exitManager);

	private static final String ERROR_NOT_COMMAND = "잘못된 명령입니다.";
	private final String command;
	private final Runnable runnable;

	MainMenu(String command, Runnable runnable) {
		this.command = command;
		this.runnable = runnable;
	}

	public static MainMenu findByCommand(String command) {
		return Arrays.stream(MainMenu.values())
			.filter(mainMenu -> mainMenu.command.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_COMMAND));
	}

	public void run() {
		this.runnable.run();
	}
}
