package pairmatching.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameData {
	List<Crew> backendCrews = new ArrayList<Crew>();
	List<Crew> frontendCrews = new ArrayList<Crew>();

	public GameData() throws FileNotFoundException {
		makeCrewsFromFile();
	}

	private void makeCrewsFromFile() throws FileNotFoundException {
		makeBackendCrew();
		makeFrontendCrew();
	}

	private void makeFrontendCrew() throws FileNotFoundException {
		URL resource = getClass().getClassLoader().getResource("frontend-crew.md");
		String filePath = resource.getFile();
		Scanner scanner = new Scanner(new File(filePath));
		while (scanner.hasNext()) {
			String name = scanner.next();
			Course course = Course.FRONTEND;
			Crew tmpCrew = new Crew(course, name);
			frontendCrews.add(tmpCrew);
		}
	}

	private void makeBackendCrew() throws FileNotFoundException {
		URL resource = getClass().getClassLoader().getResource("backend-crew.md");
		String filePath = resource.getFile();
		Scanner scanner = new Scanner(new File(filePath));
		while (scanner.hasNext()) {
			String name = scanner.next();
			Course course = Course.BACKEND;
			Crew tmpCrew = new Crew(course, name);
			backendCrews.add(tmpCrew);
		}
	}

}
