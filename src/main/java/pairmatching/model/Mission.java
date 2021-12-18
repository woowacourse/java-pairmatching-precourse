package pairmatching.model;

public class Mission {
	private String name;
	private MatchingPairs matchingPairs = null;

	public Mission(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
