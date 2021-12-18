package pairmatching.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CrewNames {
	public List<String> crewNames = new ArrayList<>();

	public CrewNames(String crewFile) {
		try {
			addCrewNames(crewFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<String> getShuffledCrewNames() {
		return Randoms.shuffle(crewNames);
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
