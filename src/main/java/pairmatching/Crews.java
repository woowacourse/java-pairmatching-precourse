package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {
	private static final String BACkEND_CREW_PATH = "src/main/resources/backend-crew.md";
	private static final String FRONTEND_CREW_PATH = "src/main/resources/frontend-crew.md";
	private static final int EXPECTED_MATCHING_STATUS_SIZE = 3;
	private static final String ERROR_INVALID_MATCHING_STATUS = "[ERROR] 잘못된 매칭 정보 입력입니다.";
	private final String course;
	private final String level;
	private final String mission;
	List<String> crewNames;
	List<String> shuffledCrew;
	private List<Pair> pairList;

	public Crews(List<String> matchingStatus) {
		if (matchingStatus.size() != EXPECTED_MATCHING_STATUS_SIZE) {
			throw new IllegalArgumentException(ERROR_INVALID_MATCHING_STATUS);
		}
		this.course = matchingStatus.get(0);
		this.level = matchingStatus.get(1);
		this.mission = matchingStatus.get(2);
		try {
			if (this.course.equals("백엔드")) {
				this.crewNames = loadCrewsFromFile(BACkEND_CREW_PATH);
				this.shuffledCrew = Randoms.shuffle(this.crewNames);
			}
			if (this.course.equals("프론트엔드")) {
				this.crewNames = loadCrewsFromFile(FRONTEND_CREW_PATH);
				this.shuffledCrew = Randoms.shuffle(this.crewNames);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.pairList = new ArrayList<>();
	}

	public static List<String> loadCrewsFromFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
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
		List<String> matchingStatus = new ArrayList<>(Arrays.asList("프론트엔드", "레벨1", "자동차경주"));
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
			if (index == this.shuffledCrew.size() - 1) {
				this.pairList.get((index - 2) / 2).addCrew(crew);
				break;
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
