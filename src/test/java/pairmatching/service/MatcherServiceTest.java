package pairmatching.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.MatchObjective;
import pairmatching.domain.Mission;

class MatcherServiceTest {

	MatcherService matcherService;

	@BeforeEach
	void setUp() {
		this.matcherService = new MatcherService();
	}

	@Test
	void match() {
		MatchObjective matchObjective = new MatchObjective(Course.BACKEND, Level.LEVEL1, "자동차게임");
		Mission mission = matcherService.match(matchObjective, 0);
		System.err.println(mission.toString());
		Assertions.assertThat(mission.toString()).contains("준섭");
	}

	@Test
	void matchTwice() {
		MatchObjective matchObjective = new MatchObjective(Course.BACKEND, Level.LEVEL1, "자동차게임");
		Mission mission = matcherService.match(matchObjective, 0);
		System.err.println(mission.toString());
		Mission mission2 = matcherService.match(matchObjective, 0);
		System.err.println(mission2.toString());
		Assertions.assertThat(mission.toString()).contains("준섭");
	}
}