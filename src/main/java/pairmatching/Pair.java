package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class Pair {

	private HashSet<String> pair;

	public Pair(String crew) {
		this.pair = new HashSet<>(Arrays.asList(crew));
	}

	public void addCrew(String crew) {
		this.pair.add(crew);
	}

	@Override
	public String toString() {
		List<String> pairList = new ArrayList<>(pair);
		return String.join(" : ", pairList);
	}
}
