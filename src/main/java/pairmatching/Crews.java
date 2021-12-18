package pairmatching;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {
	private static final String DELIMITER = " : ";
	private static final String MATCHING_RESULT = "페어 매칭 결과입니다.";
	private static final int ODD_FINAL_INDEX = 3;
	private static final int ODD_FINAL_NAME_1 = 2;
	private static final int ODD_FINAL_NAME_2 = 3;
	private static final int ODD_FINAL_NAME_3 = 4;

	public static List<String> frontEndCrewNames;
	public static List<String> backEndCrewNames;

	public static Crew[] frontEndCrews;
	public static Crew[] backEndCrews;


	public static List<List> frontEndmatchResult = new ArrayList<List>();
	public static List<List> backEndmatchResult = new ArrayList<List>();

	public static boolean crewMatch(String name1, String name2, Course course) {
		List<String> match = new ArrayList<>();
		match.add(name1);
		match.add(name2);

		if (course == Course.FRONTEND) {
			return frontEndmatchResult.add(match);
		}
		return backEndmatchResult.add(match);
	}


	public static void matchingOdd(List<String> shuffledcrewNames, Course course) {
		System.out.println(MATCHING_RESULT);
		int index = 0;
		for (int i = 0; i < shuffledcrewNames.size() - ODD_FINAL_INDEX; i += 2) {
			crewMatch(shuffledcrewNames.get(i), shuffledcrewNames.get(i + 1), course);
			System.out.println(shuffledcrewNames.get(i) + DELIMITER + shuffledcrewNames.get(i + 1));
			index = i;
		}
		crewMatch(shuffledcrewNames.get(index + ODD_FINAL_NAME_1), shuffledcrewNames.get(index + ODD_FINAL_NAME_2), course);
		crewMatch(shuffledcrewNames.get(index + ODD_FINAL_NAME_2), shuffledcrewNames.get(index + ODD_FINAL_NAME_3), course);
		crewMatch(shuffledcrewNames.get(index + ODD_FINAL_NAME_1), shuffledcrewNames.get(index + ODD_FINAL_NAME_3), course);
		System.out.println(shuffledcrewNames.get(index + ODD_FINAL_NAME_1) + DELIMITER + shuffledcrewNames.get(index + ODD_FINAL_NAME_2) + DELIMITER + shuffledcrewNames.get(index + ODD_FINAL_NAME_3));
	}

	public static void matchingEven(List<String> shuffledcrewNames, Course course) {
		System.out.println(MATCHING_RESULT);
		for (int i = 0; i < shuffledcrewNames.size(); i += 2) {
			crewMatch(shuffledcrewNames.get(i), shuffledcrewNames.get(i + 1), course);
			System.out.println(shuffledcrewNames.get(i) + DELIMITER + shuffledcrewNames.get(i + 1));
		}
	}

	public static int oddOrEven(List<String> crewNames) {
		if (crewNames.size() % 2 == 0) {
			return 0;
		}
		return 1;
	}

	private static List<String> randomShuffleBackEnd(List<String> backEndCrewList) {
		List<String> shuffledBackEndCrewNames = Randoms.shuffle(backEndCrewNames);
		System.out.println(shuffledBackEndCrewNames);

		return shuffledBackEndCrewNames;
	}

	public static List<String> randomShuffleFrontEnd(List<String> frontEndCrewList) {
		List<String> shuffledFrontEndCrewNames = Randoms.shuffle(frontEndCrewList);
		System.out.println(shuffledFrontEndCrewNames);

		return shuffledFrontEndCrewNames;
	}

	public static void makeCrews() throws IOException {
		Course backEndCourse = Course.BACKEND;
		Course frontEndCourse = Course.FRONTEND;

		List<String> frontEndCrewList = frontEndCrewList();
		List<String> backEndCrewList = backEndCrewList();

		frontEndCrews = makeFrontEndCrews(frontEndCrewList);
		backEndCrews = makeBackEndCrews(backEndCrewList);

		List<String> shuffledFrontEndCrewNames = randomShuffleFrontEnd(frontEndCrewList);
		List<String> shuffledBackEndCrewNames = randomShuffleBackEnd(backEndCrewList);


		System.out.println(Arrays.toString(frontEndCrews));
		System.out.println(Arrays.toString(backEndCrews));

		System.out.println();


		matchingEven(shuffledBackEndCrewNames, backEndCourse);
		System.out.println(backEndmatchResult);
		matchingOdd(shuffledFrontEndCrewNames, frontEndCourse);
		System.out.println(frontEndmatchResult);

	}

	public static List<String> backEndCrewList() throws IOException {
		backEndCrewNames = Files.readAllLines(Paths.get("./src/main/resources/backend-crew.md"));
		System.out.println(backEndCrewNames);

		return backEndCrewNames;
	}

	private static List<String> frontEndCrewList() throws IOException {
		frontEndCrewNames = Files.readAllLines(Paths.get("./src/main/resources/frontend-crew.md"));
		System.out.println(frontEndCrews);

		return frontEndCrewNames;
	}



	public static Crew[] makeBackEndCrews(List<String> backEndCrewList) {
		backEndCrews = new Crew[backEndCrewList.size()];
		for (int i = 0; i < backEndCrews.length; i++) {
			backEndCrews[i] = new Crew(Course.BACKEND, backEndCrewNames.get(i));
		}
		return backEndCrews;
	}

	private static Crew[] makeFrontEndCrews(List<String> frontEndCrewList) {
		frontEndCrews = new Crew[frontEndCrewList.size()];
		for (int j = 0; j < frontEndCrews.length; j++) {
			frontEndCrews[j] = new Crew(Course.FRONTEND, frontEndCrewNames.get(j));
		}
		return frontEndCrews;
	}
}
