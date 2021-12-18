package pairmatching.domain;

import java.util.List;

import pairmatching.domain.crew.Crews;
import pairmatching.domain.input.Course;
import pairmatching.domain.input.Level;
import pairmatching.domain.matching.Matching;
import pairmatching.domain.matching.Matchings;
import pairmatching.domain.matching.Pair;

public class PairMatcher {
	private static final String DELIMITER = ", ";
	private static final int IDX_COURSE = 0;
	private static final int IDX_LEVEL = 1;
	private static final int IDX_MISSION = 2;

	private Matchings matchings;
	Crews frontEndCrews;
	Crews backEndCrews;

	public PairMatcher() {
		this.matchings = Matchings.newInstance();
		this.frontEndCrews = Crews.of("src/main/resources/frontend-crew.md", Course.FRONTEND);
		this.backEndCrews = Crews.of("src/main/resources/backend-crew.md", Course.BACKEND);
	}

	public void matchPairs(String matchingTarget) {
		validateMatchingTarget(matchingTarget);
		String[] matchingTargetInfo = matchingTarget.split(DELIMITER);

		Course course = Course.fromCourseName(matchingTargetInfo[IDX_COURSE]);
		Level level = Level.fromLevelName(matchingTargetInfo[IDX_LEVEL]);
		String mission = matchingTargetInfo[IDX_MISSION];

		List<Pair> pairList = frontEndCrews.generatePairs();

		Matching matching = new Matching(course, level, mission, pairList);

		matchings.add(matching);

	}

	public void validateMatchingTarget(String matchingTarget) {
		if (!matchingTarget.matches("[^,]+,\\s[^,]+,\\s[^,]+")) {
			throw new IllegalArgumentException("잘못된 입력 형식입니다.");
		}

	}

	public void resetMatchingInfo() {
		matchings.reset();
	}

}
