package pairmatching.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class InputView {

	public static List<String> getCrew(String path) {
		List<String> crews = new LinkedList<>();
		try {
			BufferedReader reader = new BufferedReader(
				new FileReader(path)
			);
			String crew;
			while ((crew = reader.readLine()) != null) {
				crews.add(crew);
			}
			reader.close();
			return crews;
		} catch (Exception e) {
			logError(e);
			return new LinkedList<>();
		}
	}

	private static void logError(Exception error) {
		System.out.println(error.getMessage());
	}

}
