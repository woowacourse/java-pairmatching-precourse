package pairmatching.utill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;

public class CrewFileReader {
	public static List<String> getCrewList(Course course) throws IOException {
		File file = getFile(course);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		List<String> crewList = new ArrayList<>();
		String crewName = "";
		while ((crewName = bufferedReader.readLine()) != null) {
			crewList.add(crewName);
		}

		return crewList;
	}

	private static File getFile(Course course) {
		if (course.equals(Course.BACKEND)) {
			return new File("/src/main/resources/backend-crew.md");
		}
		return new File("/src/main/resources/frontend-crew.md");
	}
}
