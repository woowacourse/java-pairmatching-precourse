package pairmatching.domain;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PairMatching {

	private List<String> roll;

	private MainMenu mainMenu;
	private Level level;
	private Crew crew;


	public PairMatching() throws IOException {
		this.mainMenu = new MainMenu();
		this.level = new Level();
		roll = Arrays.asList("백엔드", "프론트엔드");
		this.crew = new Crew();
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public Level getLevel() {
		return level;
	}

	public List<String> getGetRoll() {
		return roll;
	}

	public Crew getCrew() {
		return crew;
	}

	public void makeRandomMatching(String roll, String level) {
		if (roll.equals("백엔드")) {
			getCrew().createBackendMatching(getLevel().getLevelMap(), level);
		}

	}

	public void doesExistMatchingInfo() {

	}
}
