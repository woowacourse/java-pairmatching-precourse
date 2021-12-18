package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.common.Course;

public class ReadFile {
	public static List<String> readCrewNameList (Course course) throws IOException {
		List<String> crewNameList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(course.getPath()));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			crewNameList.add(line);
		}
		br.close();
		return crewNameList;
	}
}
