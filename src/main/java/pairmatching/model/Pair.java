package pairmatching.model;

import java.util.List;

public class Pair {
	List<String> pair;

	public Pair(List<String> pair) {
		this.pair = pair;
	}

	public boolean isSamePair(List<String> pair) {
		for (String currentCrew:
			 pair) {
			if (!this.pair.contains(currentCrew)) {
				return false;
			}
		}
		return true;
	}
}
