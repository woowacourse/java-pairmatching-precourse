package pairmatching.initialize;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewRepository;

public class CrewInitialize {
	public static void readFiles() {
		crewRead("./src/main/resources/backend-crew.md", Course.BACKEND);
		crewRead("./src/main/resources/frontend-crew.md", Course.FRONTEND);
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
