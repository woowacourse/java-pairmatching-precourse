package pairmatching.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import pairmatching.models.Course;

public class NameList {

	private final static String COMMON_PATH = "/src/main/resources";

	private final static String BACKEND_CREW_PATH = "/backend-crew.md";

	private final static String FRONTEND_CREW_PATH = "/frontend-crew.md";

	private String makePath(final String course) {
		final String absolutePath = (new File("")).getAbsolutePath();
		if(course.equals(Course.BACKEND.getName())) {
			return absolutePath + COMMON_PATH + BACKEND_CREW_PATH;
		}
		return absolutePath + COMMON_PATH + FRONTEND_CREW_PATH;
	}

	public void readName(final String course) throws IOException {
		final String filePath = makePath(course);
		BufferedReader readFile = new BufferedReader(new FileReader(filePath));
		while(true) {
			String line = readFile.readLine();
			if(line == null) break;
			System.out.println(line);
		}
		readFile.close();
	}

}
