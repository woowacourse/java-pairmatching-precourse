package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public class PairMatching {
	private MainMenu mainMenu;
	private List<String> roll;

	public PairMatching() {
		this.mainMenu = new MainMenu();
		roll = Arrays.asList("백엔드", "프론트엔드");
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public List<String> getGetRoll() {
		return roll;
	}
}
