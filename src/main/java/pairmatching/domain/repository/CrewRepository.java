package pairmatching.domain.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewRepository {
	static List<Crew> backEndCrewList = new ArrayList<>();
	static List<Crew> frontEndCrewList = new ArrayList<>();

	static {
		try {
			insertCrewInBackEnd();
			insertCrewInFrontEnd();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void insertCrewInBackEnd() throws IOException {
		BufferedReader reader = new BufferedReader(
			new FileReader("/Users/jochungbeom/finalCote/java-pairmatching-precourse/src/main/resources/backend-crew.md")
		);
		String crew;
		while ((crew = reader.readLine()) != null) {
			backEndCrewList.add(new Crew(Course.BACKEND, crew));
		}
		reader.close();
	}

	public static void insertCrewInFrontEnd() throws IOException {
		BufferedReader reader = new BufferedReader(
			new FileReader("/Users/jochungbeom/finalCote/java-pairmatching-precourse/src/main/resources/frontend-crew.md")
		);
		String crew;
		while ((crew = reader.readLine()) != null) {
			frontEndCrewList.add(new Crew(Course.FRONTEND, crew));
		}
		reader.close();
	}

	public static ArrayList<Crew> getBackEndCrewList() {
		return (ArrayList<Crew>)backEndCrewList;
	}

	public static ArrayList<Crew> getFrontEndCrewList() {
		return (ArrayList<Crew>)frontEndCrewList;
	}
}
