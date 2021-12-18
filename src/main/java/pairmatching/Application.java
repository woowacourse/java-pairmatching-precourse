package pairmatching;

import static pairmatching.model.CrewRepository.*;
import static pairmatching.model.MissionRepository.*;

import java.util.List;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.CrewRepository;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.MissionRepository;
import pairmatching.utils.FileUtils;

public class Application {
	public static void main(String[] args) {
		init();
	}

	private static void init() {
		initBackendCrews();
		initFrontendCrews();
		initMissions();
	}

	private static void initMissions() {
		MissionRepository.addMission(new Mission(Level.LEVEL1, "자동차경주"));
		MissionRepository.addMission(new Mission(Level.LEVEL1, "로또"));
		MissionRepository.addMission(new Mission(Level.LEVEL1, "숫자야구게임"));

		MissionRepository.addMission(new Mission(Level.LEVEL2, "장바구니"));
		MissionRepository.addMission(new Mission(Level.LEVEL2, "결제"));
		MissionRepository.addMission(new Mission(Level.LEVEL2, "지하철 노선도"));

		MissionRepository.addMission(new Mission(Level.LEVEL4, "성능개선"));
		MissionRepository.addMission(new Mission(Level.LEVEL4, "배포"));
	}

	private static void initFrontendCrews() {
		String filePath = "./src/main/resources/frontend-crew.md";
		List<String> frontendCrews = FileUtils.readList(filePath);

		for (String frontendCrew : frontendCrews) {
			CrewRepository.addCrew(new Crew(Course.FRONTEND, frontendCrew));
		}
	}

	private static void initBackendCrews() {
		String filePath = "./src/main/resources/backend-crew.md";
		List<String> backendCrews = FileUtils.readList(filePath);

		for (String backendCrew : backendCrews) {
			CrewRepository.addCrew(new Crew(Course.BACKEND, backendCrew));
		}
	}
}
