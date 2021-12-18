package pairmatching.domain;

import java.util.List;

public class Matching {
	private List<Pair> pairs;
	MatchingOption matchingOption;

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
