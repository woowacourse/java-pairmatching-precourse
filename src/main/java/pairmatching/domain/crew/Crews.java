package pairmatching.domain.crew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Crews {
	List<String> crewNames;
	List<String> shuffledCrews;

	public Crews(String fileName) {
		crewNames = new ArrayList<>();
		readCrewFile(fileName);
	}

	public void readCrewFile(String fileName) {
		String line;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {
			while ((line = br.readLine()) != null) {
				crewNames.add(line);
			}
		} catch (IOException ignored) {
		}
	}
}
