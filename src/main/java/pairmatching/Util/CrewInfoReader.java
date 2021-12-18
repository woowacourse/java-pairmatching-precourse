package pairmatching.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.Domain.Course;
import pairmatching.Domain.Crew;

public class CrewInfoReader {
	public static List<Crew> getBackendCrewInfo() {
		List<Crew> crewList = new ArrayList<>();
		try (FileReader rw = new FileReader(
			"C:\\Users\\rkdtk\\Documents\\GitHub\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");
			 BufferedReader br = new BufferedReader(rw);) {
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				crewList.add(new Crew(Course.BACKEND, readLine));
			}
		} catch (IOException e) {
			System.out.println("e");
		}
		return crewList;
	}

	public static List<Crew> getFrontendCrewInfo() {
		List<Crew> crewList = new ArrayList<>();
		try (FileReader rw = new FileReader(
			"C:\\Users\\rkdtk\\Documents\\GitHub\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md");
			 BufferedReader br = new BufferedReader(rw);) {
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				crewList.add(new Crew(Course.BACKEND, readLine));
			}
		} catch (IOException e) {
			System.out.println("e");
		}
		return crewList;
	}
}
