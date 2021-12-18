package pairmatching.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewNames {
	public List<String> crewNames = new ArrayList<>();

	public CrewNames(String crewFile) {
		try {
			addCrewNames(crewFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void addCrewNames(String crewFile) throws IOException {
		BufferedReader reader = new BufferedReader(
			new FileReader(crewFile)
		);

		String name;
		while ((name = reader.readLine()) != null) {
			crewNames.add(name);
		}

		reader.close();
	}

}
