package pairmatching;

import java.io.*;
import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.CrewRepository;

public class Application {
	private static final CrewsReader CREWS_READER = new CrewsReader();

	public static void main(String[] args) {
		// TODO 구현 진행
		saveCrews();

	}

	private static void saveCrews() {
		saveBackendCrews();
		saveFrontendCrews();
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
