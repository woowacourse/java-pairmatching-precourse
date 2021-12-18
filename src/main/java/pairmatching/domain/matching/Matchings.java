package pairmatching.domain.matching;

import java.util.ArrayList;
import java.util.List;

public class Matchings {
	private final List<Matching> matchingList;

	private Matchings() {
		this.matchingList = new ArrayList<>();
	}

	public static Matchings newInstance() {
		return new Matchings();
	}

	public void reset() {
		matchingList.clear();
	}

	public void add(Matching matching) {
		matchingList.add(matching);
	}

}
