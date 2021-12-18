package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {
	private static final String BACkEND_CREW_PATH = "src/main/resources/backend-crew.md";
	List<String> crewNames;
	List<String> shuffledCrew;

	public Crews() throws IOException {
		this.crewNames = readFile();
		this.shuffledCrew = Randoms.shuffle(crewNames);
	}

	public static List<String> readFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(BACkEND_CREW_PATH));
		List<String> crewNames = new ArrayList<>();
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			crewNames.add(line);
		}
		br.close();
		return crewNames;
	}

	public static void main(String[] args) throws IOException {
		Crews backEnd = new Crews();
		backEnd.crewNames.forEach(System.out::println);
		System.out.println();
		backEnd.shuffledCrew.forEach(System.out::println);
	}
}
