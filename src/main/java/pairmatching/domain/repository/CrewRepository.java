package pairmatching.domain.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
	public static List<String> backEndCrewList = new ArrayList<>();
	public static List<String> frontEndCrewList = new ArrayList<>();
	public static final String backEndListFileURL = "/Users/jochungbeom/finalCote/java-pairmatching-precourse/src/main/resources/backend-crew.md";
	public static final String FrontEndListFileURL = "/Users/jochungbeom/finalCote/java-pairmatching-precourse/src/main/resources/frontend-crew.md";

	static {
		try {
			insertCrewInBackEnd();
			insertCrewInFrontEnd();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void insertCrewInBackEnd() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(backEndListFileURL));
		String crew;
		while ((crew = reader.readLine()) != null) {
			backEndCrewList.add(crew);
		}
		reader.close();
	}

	public static void insertCrewInFrontEnd() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(FrontEndListFileURL));
		String crew;
		while ((crew = reader.readLine()) != null) {
			frontEndCrewList.add(crew);
		}
		reader.close();
	}

	public static List<String> getBackEndCrewList() {
		return backEndCrewList;
	}

	public static List<String> getFrontEndCrewList() {
		return frontEndCrewList;
	}
}
