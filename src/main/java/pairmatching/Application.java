package pairmatching;

import static pairmatching.model.CrewRepository.*;

import java.util.List;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.utils.FileUtils;

public class Application {
	public static void main(String[] args) {
		init();
	}

	private static void init() {
		initBackendCrews();
		initFrontendCrews();
	}

	private static void initFrontendCrews() {
		String filePath = "./src/main/resources/frontend-crew.md";
		List<String> frontendCrews = FileUtils.readList(filePath);

		for (String frontendCrew : frontendCrews) {
			crews.add(new Crew(Course.FRONTEND, frontendCrew));
		}
	}

	private static void initBackendCrews() {
		String filePath = "./src/main/resources/backend-crew.md";
		List<String> backendCrews = FileUtils.readList(filePath);

		for (String backendCrew : backendCrews) {
			crews.add(new Crew(Course.BACKEND, backendCrew));
		}
	}
}
