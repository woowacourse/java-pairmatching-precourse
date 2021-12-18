package pairmatching;

import java.util.Arrays;
import pairmatching.controller.PairMatchingController;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.CrewRepository;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.MissionRepository;

public class Application {
	private static final CrewsReader CREWS_READER = new CrewsReader();

	public static void main(String[] args) {
		saveInitialData();
		PairMatchingController controller = new PairMatchingController();
		controller.service();
	}

	private static void saveInitialData() {
		saveMissions();
		saveCrews();
	}

	private static void saveCrews() {
		saveBackendCrews();
		saveFrontendCrews();
	}

	private static void saveMissions() {
		saveMissionsWithLevel(Level.LEVEL_1, "자동차경주", "로또", "숫자야구게임");
		saveMissionsWithLevel(Level.LEVEL_2, "장바구니", "결제", "지하철노선도");
		saveMissionsWithLevel(Level.LEVEL_4, "성능개선", "배포");
	}

	private static void saveMissionsWithLevel(Level level, String... missionNames) {
		Arrays.stream(missionNames)
			.map(name -> Mission.of(level, name))
			.forEach(MissionRepository::save);
	}

	private static void saveBackendCrews() {
		CREWS_READER.readBackendCrews().stream()
			.map(name -> Crew.of(name, Course.BACKEND))
			.forEach(CrewRepository::save);
	}

	private static void saveFrontendCrews() {
		CREWS_READER.readFrontCrews().stream()
			.map(name -> Crew.of(name, Course.FRONTEND))
			.forEach(CrewRepository::save);
	}
}
