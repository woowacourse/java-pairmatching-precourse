package pairmatching.domain.crew;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.input.Course;
import pairmatching.domain.matching.Pair;

public class Crews {
	private List<Crew> crewList;

	private Crews(List<Crew> crewList) {
		this.crewList = crewList;
	}

	public static Crews of(String pathName, Course course) {
		List<Crew> crewList = new ArrayList<>();

		try {
			File file = new File(pathName);

			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String name = scan.nextLine();
				Crew crew = new Crew(course, name);
				crewList.add(crew);

				return new Crews(crewList);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
		return null;

		// TODO: null 처리, try with resource 구문?
	}

	public List<Pair> generatePairs() {
		List<Pair> pairList = new ArrayList<>();
		List<String> shuffledCrewList = shuffle();

		while (shuffledCrewList.size() > 1) {
			Pair pair = Pair.newInstance();

			String firstName = shuffledCrewList.remove(0);
			String secondName = shuffledCrewList.remove(0);

			pair.add(firstName);
			pair.add(secondName);

			if (shuffledCrewList.size() == 1) {
				String thirdName = shuffledCrewList.remove(0);
				pair.add(thirdName);
			}

			pairList.add(pair);
		}
		return pairList;
	}

	public List<String> shuffle() {
		return Randoms.shuffle(crewList.stream()
			.map(Crew::getName)
			.collect(Collectors.toList()));
	}

	public boolean isOdd() {
		return crewList.size() % 2 == 0;
	}
}
