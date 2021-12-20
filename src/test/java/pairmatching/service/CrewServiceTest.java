package pairmatching.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.Mission;
import pairmatching.util.CrewReadUtils;

class CrewServiceTest {

	private CrewService crewService;

	@BeforeEach
	void setUp() {
		this.crewService = new CrewService(CrewReadUtils.readCrews(Course.BACKEND));
	}

	@Test
	void match() {
		List<String> crewNames = CrewReadUtils.readCrews(Course.BACKEND);
		Mission mission = new Mission(Course.BACKEND, Level.LEVEL1, "자동차게임");
		Mission result = crewService.match(mission, 0);
		Assertions.assertThat(crewNames).allSatisfy(s -> Assertions.assertThat(result.toString()).containsOnlyOnce(s));
	}
}