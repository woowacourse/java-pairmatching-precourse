package pairmatching.initialize;

import static pairmatching.Constants.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewRepository;

public class CrewInitialize {
	public static void readFiles() {
		crewRead(BACKEND_PATH, Course.BACKEND);
		crewRead(FRONTEND_PATH, Course.FRONTEND);
	}

	private static void crewRead(String path, Course course) {
		try (Scanner scanner = new Scanner(new File(path))) {
			while (scanner.hasNext()) {
				String crewName = scanner.next();
				CrewRepository.addCrew(Crew.of(crewName, course));
			}
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}
}
