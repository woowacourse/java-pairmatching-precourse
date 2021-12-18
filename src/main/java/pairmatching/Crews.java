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
		this.crewNames = loadCrewsFromFile();
		this.shuffledCrew = Randoms.shuffle(crewNames);
	}

	public static List<String> loadCrewsFromFile() throws IOException {
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
		List<Pair> pairList = backEnd.makePairs();
		for (Pair pair : pairList) {
			System.out.println(pair.toString());
		}
	}

	public List<Pair> makePairs() {
		List<Pair> pairList = new ArrayList<>();
		int index = 0;
		for (String crew : this.shuffledCrew) {
			if (index % 2 == 1) {
				System.out.println("size of pairList: " + pairList.size());
				System.out.println("index: " + index);
				pairList.get((index - 1) / 2).addCrew(crew);
				index += 1;
				continue;
			}
			pairList.add(new Pair(crew));
			index += 1;
		}
		return pairList;
	}

	public boolean isReShuffle(List<Pair> originalPairs, List<Pair> shuffledPairs) {
		for (Pair pair : shuffledPairs) {
			if (originalPairs.contains(pair)) {
				return true;
			}
		}
		return false;
	}
}
