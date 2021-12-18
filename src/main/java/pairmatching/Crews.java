package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {
	private static final String BACkEND_CREW_PATH = "src/main/resources/backend-crew.md";
	private final String course;
	private final String level;
	private final String mission;
	List<String> crewNames;
	List<String> shuffledCrew;
	private List<Pair> pairList;

	public Crews(List<String> matchingStatus) {
		this.course = matchingStatus.get(0);
		this.level = matchingStatus.get(1);
		this.mission = matchingStatus.get(2);
		try {
			this.crewNames = loadCrewsFromFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.shuffledCrew = Randoms.shuffle(crewNames);
		this.pairList = new ArrayList<>();
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

	public static void main(String[] args) {
		List<String> matchingStatus = new ArrayList<>();
		Crews backEnd = new Crews(matchingStatus);
		backEnd.crewNames.forEach(System.out::println);
		System.out.println();
		backEnd.shuffledCrew.forEach(System.out::println);
		List<Pair> pairList = backEnd.makePairs();
		for (Pair pair : pairList) {
			System.out.println(pair.toString());
		}
	}

	public List<Pair> makePairs() {
		int index = 0;
		for (String crew : this.shuffledCrew) {
			if (index % 2 == 1) {
				this.pairList.get((index - 1) / 2).addCrew(crew);
				index += 1;
				continue;
			}
			this.pairList.add(new Pair(crew));
			index += 1;
		}
		return this.pairList;
	}

	public boolean isReShuffle(List<Pair> originalPairs, List<Pair> shuffledPairs) {
		for (Pair pair : shuffledPairs) {
			if (originalPairs.contains(pair)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Crews crews = (Crews)o;
		return Objects.equals(course, crews.course) && Objects.equals(level, crews.level)
			&& Objects.equals(mission, crews.mission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);
	}

	public List<Pair> getPairs() {
		return this.pairList;
	}
}
