package pairmatching.domain;

public enum MainView {
	MATCHING(1),
	SEARCHING(2),
	INITIALIZING(3),
	QUIT(4);

	private final int number;

	MainView(int number) {
		this.number = number;
	}

	public static MainView valueOf(int number) {
		for (MainView mainView : MainView.values()) {
			if (mainView.getNumber() == number) {
				return mainView;
			}
		}
		return null;
	}

	public int getNumber() {
		return number;
	}

	public boolean isMatching() {
		return this == MATCHING;
	}

	public boolean isSearching() {
		return this == SEARCHING;
	}

	public boolean isInitializing() {
		return this == INITIALIZING;
	}

	public boolean isExit() {
		return this == QUIT;
	}
}
