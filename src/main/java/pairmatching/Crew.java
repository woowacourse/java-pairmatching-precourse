package pairmatching;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crew {
	private Course course;
	private String name;

	public static List<String> getCrewNames(Course course) throws IOException {
		List<String> crewNames = new ArrayList<>();
		Scanner scanner = null;

		if(course == Course.BACKEND){
			scanner = new Scanner(new File("../resources.backend-crew.md"));
		}else if(course == Course.FRONTEND){
			scanner = new Scanner(new File("../resources.frontend-crew.md"));
		}

		while (scanner.hasNext()) {
			crewNames.add(scanner.next());
		}
		Crew._validateCrewNames(crewNames);
		return crewNames;
	}

	private static void _validateCrewNames(List<String> crewNames){
		if (crewNames.size() != crewNames.stream().distinct().count()) {
			throw new IllegalArgumentException("[ERROR] 크루이름은 중복될 수 없습니다.");
		}
	}
}
