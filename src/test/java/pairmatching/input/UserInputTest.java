package pairmatching.input;

import static pairmatching.constant.ErrorMessages.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pairmatching.domains.mission.Missions;
import pairmatching.exceptions.UserInputException;
import pairmatching.view.InputView;

public class UserInputTest {

	Missions missions = new Missions();

	@BeforeEach
	void beforeEach() {
		missions.loadMission();
	}

	@Test
	void containDeatilTest() {
		//given

		//when
		String userInput = "프론트엔드, 자동차게임";

		//then
		Assertions.assertThatThrownBy(() -> {
				UserInputException.isMission(userInput);
			})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(MISSION_DETAIL_NULL);
	}

	@Test
	void isCourseTest() {
		//given

		//when
		String userInput = "미들엔드, 레벨1, 자동차게임";

		//then
		Assertions.assertThatThrownBy(() -> {
				missions.findMissionByInput(userInput);
			})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(COURSE_NULL);
	}

	@Test
	void isMissionTest() {
		//given

		//when
		String userInput = "프론트엔드, 레벨1, 오징어게임";

		//then
		Assertions.assertThatThrownBy(() -> {
				missions.findMissionByInput(userInput);
			})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(MISSION_NULL);
	}
}
