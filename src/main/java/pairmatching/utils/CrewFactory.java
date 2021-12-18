package pairmatching.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.model.Course;
import pairmatching.model.Crew;

public class CrewFactory {

	private CrewFactory() {
	}

	public static List<Crew> loadBackendCrews() {
		try{
			File file = new File(System.getProperty("user.dir")+"/src/main/resources/backend-crew.md");
			BufferedReader bufReader = new BufferedReader(new FileReader(file));
			String crew = "";
			List<Crew> backendCrews = new ArrayList<>();
			while ((crew = bufReader.readLine()) != null) {
				backendCrews.add(new Crew(Course.BACKEND, crew));
			}
			bufReader.close();
			return backendCrews;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return loadBackendCrews();
	}

	public static List<Crew> loadFrontendCrews() {
		try{
			File file = new File(System.getProperty("user.dir")+"/src/main/resources/frontend-crew.md");
			BufferedReader bufReader = new BufferedReader(new FileReader(file));
			String crew = "";
			List<Crew> frontendCrews = new ArrayList<>();
			while ((crew = bufReader.readLine()) != null) {
				frontendCrews.add(new Crew(Course.FRONTEND, crew));
			}
			bufReader.close();
			return frontendCrews;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return loadFrontendCrews();
	}
}
