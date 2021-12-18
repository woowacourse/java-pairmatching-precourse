package pairmatching.domain;

import java.util.List;

public class Matching {
	private List<Pair> pairs;
	MatchingOption matchingOption;

	public Matching(List<Pair> pairs, MatchingOption matchingOption) {
		this.pairs = pairs;
		this.matchingOption = matchingOption;
	}

	public List<Pair> getPairs() {
		return pairs;
	}

	public boolean isMatched(MatchingOption matchingOption) {
		if (this.matchingOption.getCourse().equals(matchingOption.getCourse())
			&& this.matchingOption.getMission() == matchingOption.getMission()) {
			return true;
		}
		return false;
	}

	public boolean isCourse(Course course) {
		return matchingOption.getCourse() == course;
	}
}
