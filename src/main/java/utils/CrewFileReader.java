package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewFileReader {

	private CrewFileReader() {
	}

	public static List<String> readBackEndCrewFile() {
		try {
			List<String> backEndCrews = new ArrayList<>();
			File file = new File("./src/main/resources/backend-crew.md");
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				backEndCrews.add(line);
			}
			bufReader.close();
			return backEndCrews;
		} catch (IOException e) {
			return null;
		}
	}

	public static List<String> readFrontEndCrewFile() {
		try {
			List<String> frontEndCrews = new ArrayList<>();
			File file = new File("./src/main/resources/frontend-crew.md");
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				frontEndCrews.add(line);
			}
			bufReader.close();
			return frontEndCrews;
		} catch (IOException e) {
			return null;
		}
	}
}
