package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crew {
	private String name;
	private String process;
	private List<String> matchedLevels = new ArrayList<>();

	public Crew(String name, String process) {
		this.name = name;
		this.process = process;
	}

	public String getName() {
		return name;
	}

	public void addMatchedLevel(String level) {
		matchedLevels.add(level);
	}

	public boolean isAlreadyMatched(String level) {
		if (matchedLevels.isEmpty()) {
			return false;
		}
		if (matchedLevels.stream().noneMatch(matchedLevel -> matchedLevel.equals(level))) {
			return false;
		}
		return true;
	}
}
