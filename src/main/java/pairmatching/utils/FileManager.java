package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class FileManager {
	public static List<Crew> loadCrewFromFile(String filePath) {
		String file = filePath;

		List<Crew> crews = new ArrayList<>();

		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);

			while (true) {
				String currentLine = br.readLine();
				if (currentLine == null) {
					break;
				}

				if (filePath.contains("back")) {
					crews.add(new Crew(Course.BACKEND, currentLine));
				}
				if (filePath.contains("front")) {
					crews.add(new Crew(Course.FRONTEND, currentLine));
				}
			}

			br.close();
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다..");
		} catch (IOException e) {
			System.out.println("파일 읽기 중 문제가 발생했습니다.");
		}

		return crews;
	}

}
