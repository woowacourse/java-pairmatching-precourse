package pairmatching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Reader {
	private static final String RESOURCE_DIRECTORY = "/Users/younsangjun/java-pairmatching-precourse/src/main/resources/";
	private static final String FILE_READ_ERROR = "[ERROR] 파일 입출력에 문제가 있습니다";
	private static final String BACKEND_CREW_NAME_FILE = "backend-crew.md";
	private static final String FRONTEND_CREW_NAME_FILE = "frontend-crew.md";

	private Reader() {
	}

	public static CrewList getFrontEndCrewList() {
		List<String> lines = readFile(FRONTEND_CREW_NAME_FILE);
		CrewList list = new CrewList(Course.FRONTEND);
		lines.forEach(line -> list.addCrew(new Crew(line, Course.FRONTEND)));
		return list;
	}

	public static CrewList getBackEndEndCrewList() {
		List<String> lines = readFile(FRONTEND_CREW_NAME_FILE);
		CrewList list = new CrewList(Course.BACKEND);
		lines.forEach(line -> list.addCrew(new Crew(line, Course.BACKEND)));
		return list;
	}

	public static List<String> readFile(String fileName) {
		try {
			List<String> lines = new ArrayList<>();
			File file = new File(RESOURCE_DIRECTORY + fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader((fileReader));
			String line;
			while ((line = bufReader.readLine()) != null) {
				lines.add(line);
			}
			bufReader.close();
			return lines;
		} catch (IOException e) {
			throw new IllegalArgumentException(FILE_READ_ERROR);
		}
	}

}
