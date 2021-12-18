package pairmatching;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {

	public static List<String> backEndCrewNames;
	public static List<String> frontEndCrewNames;

	public static List<String> shuffledBackEndCrewNames;
	public static List<String> shuffledFrontEndCrewNames;

	public static Crew[] backEndCrews;
	public static Crew[] frontEndCrews;

	private static void randomShuffleBackEnd() {
		shuffledBackEndCrewNames = Randoms.shuffle(backEndCrewNames);
		System.out.println(shuffledBackEndCrewNames);
	}

	public static void randomShuffleFrontEnd() {
		shuffledFrontEndCrewNames = Randoms.shuffle(frontEndCrewNames);
		System.out.println(shuffledFrontEndCrewNames);
	}

	public static void makeCrews() throws IOException {
		makeBackEndCrews();
		makeFrontEndCrews();
		System.out.println(Arrays.toString(makeBackEndCrews()));
		System.out.println(Arrays.toString(makeFrontEndCrews()));

		System.out.println();

		randomShuffleBackEnd();
		randomShuffleFrontEnd();

	}

	public static Crew[] makeBackEndCrews() throws IOException {
		backEndCrewNames = Files.readAllLines(Paths.get("./src/main/resources/backend-crew.md"));
		backEndCrews = new Crew[backEndCrewNames.size()];
		for (int i = 0; i < backEndCrews.length; i++) {
			backEndCrews[i] = new Crew(Course.BACKEND, backEndCrewNames.get(i));
		}
		return backEndCrews;
	}

	private static Crew[] makeFrontEndCrews() throws IOException {
		frontEndCrewNames = Files.readAllLines(Paths.get("./src/main/resources/frontend-crew.md"));
		frontEndCrews = new Crew[frontEndCrewNames.size()];
		for (int j = 0; j < frontEndCrews.length; j++) {
			frontEndCrews[j] = new Crew(Course.FRONTEND, frontEndCrewNames.get(j));
		}
		return frontEndCrews;
	}
}
