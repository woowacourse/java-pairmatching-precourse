package pairmatching.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import pairmatching.model.Course;
import pairmatching.model.Crew;

public class FileUtils {
	public static List<Crew> read(String filePath, Course course) {
		List<Crew> crewList = new ArrayList<>();
		try {
			File file = new File(filePath);
			FileReader fileReader = new FileReader(file);
			crewList = readReader(fileReader, course);

		} catch (Exception e) {
			e.getStackTrace();
		}
		return crewList;
	}

	public static List<Crew> readReader(Reader input, Course course) throws IOException {
		try {
			BufferedReader in = new BufferedReader(input);
			String line;
			List<Crew> crewList = new ArrayList<>();

			while((line=in.readLine()) != null) {
				Crew crew = new Crew();
				crew.initCrew(course, line);
				crewList.add(crew);
			}
			return crewList;
		} finally {
			input.close();
		}
	}
}
