package pairmatching.domain;

import pairmatching.domain.crew.Crews;
import pairmatching.domain.input.Course;
import pairmatching.domain.matching.Matchings;

public class PairMatcher {
	private Matchings matchings;
	Crews frontEndCrews;
	Crews backEndCrews;

	public PairMatcher() {
		this.matchings = Matchings.newInstance();
		this.frontEndCrews = Crews.of("src/main/resources/frontend-crew.md", Course.FRONTEND);
		this.backEndCrews = Crews.of("src/main/resources/backend-crew.md", Course.BACKEND);
	}

	public void resetMatchingInfo() {
		matchings.reset();
	}

}
