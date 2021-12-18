package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	private List<String> pair = new ArrayList<>();

	public Pair(String name1, String name2) {
		pair.add(name1);
		pair.add(name2);
	}

	public Pair(String name1, String name2, String name3) {
		pair.add(name1);
		pair.add(name2);
		pair.add(name3);
	}
}
