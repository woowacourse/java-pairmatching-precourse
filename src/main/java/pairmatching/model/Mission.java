package pairmatching.model;

import java.util.ArrayList;

public class Mission {
	Level level;
	String name;
	public ArrayList<String> pairs;

	public Mission(Level level, String name) {
		this.level = level;
		this.name = name;
		this.pairs = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<String> getPairs() {
		return this.pairs;
	}

	public Level getLevel() {
		return this.level;
	}

	public void initPairs() {
		this.pairs.clear();
	}
}
