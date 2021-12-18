package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	List<String> names;

	public Pair() {
		this.names = new ArrayList<>();
	}

	public void addName(String name) {
		names.add(name);
	}
}
