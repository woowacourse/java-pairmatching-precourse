package pairmatching.Domain;

import java.util.ArrayList;
import java.util.List;

public class Mission {
	private Level level;
	private String name;
	private List<String> pairList = new ArrayList<>();

	public Mission(Level level, String name) {
		this.level = level;
		this.name = name;
	}

	public boolean levelCheck(Level level) {
		return this.level == level;
	}

	public String getName() {
		return this.name;
	}
}
