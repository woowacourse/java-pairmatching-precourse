package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Mission;

public class CrewsGenerator {
	public static final String FRONTEND = "frontend-crew.md";
	public static final String BACKEND = "backend-crew.md";

	public static List<Crew> generateCrews(Mission mission) {
		List<Crew> crews = new ArrayList<>();
		ClassLoader loader = PairGenerator.class.getClassLoader();
		try {
			FileInputStream file = new FileInputStream(loader.getResource(getFile(mission)).getFile());
			BufferedReader br = new BufferedReader(new InputStreamReader(file));
			String name = null;

			while ((name = br.readLine()) != null) {
				crews.add(new Crew(mission.getCourse(), name));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return crews;
	}

	private static String getFile(Mission mission) {
		if (mission.isFrontEnd()) {
			return FRONTEND;
		}
		return BACKEND;
	}
}
