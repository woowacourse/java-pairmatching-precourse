package pairmatching.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Menu;
import pairmatching.domain.matcing.MatchingRepository;

public class MatchingController {

	private final MatchingRepository matchingRepository;

	public MatchingController(MatchingRepository matchingRepository) {
		this.matchingRepository = matchingRepository;
	}

	public void matching(Menu menu) {
		List<String> crewNames = createCrewNames(menu.getCourse());
	}

	private List<String> createCrewNames(Course course) {
		ArrayList<String> crewNames = new ArrayList<>();
		String filePath = "src/main/resources/" + course.name().toLowerCase() + "-crew.md";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String crewName;
			while ((crewName = reader.readLine()) != null) {
				crewNames.add(crewName);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return crewNames;
	}

}
