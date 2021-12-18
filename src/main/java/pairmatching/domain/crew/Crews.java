package pairmatching.domain.crew;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pairmatching.domain.input.Course;

public class Crews {
	private final List<Crew> crewList;

	private Crews(List<Crew> crewList) {
		this.crewList = crewList;
	}

	public static Crews of(String pathName, Course course) {
		List<Crew> crewList = new ArrayList<>();

		try {
			File file = new File(pathName);

			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String name = scan.nextLine();
				Crew crew = new Crew(course, name);
				crewList.add(crew);

				return new Crews(crewList);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
		return null;

		// TODO: null 처리, try with resource 구문?
	}
}
