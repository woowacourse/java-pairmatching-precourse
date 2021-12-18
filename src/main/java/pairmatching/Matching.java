package pairmatching;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Matching {

	static List<String> CrewNames;
	static List<String> shuffledCrew;
	static ArrayList<String> three = new ArrayList<>();
	static Course matchCourse;
	static Level matchLevel;
	static String matchMission;
	static List<Crew> CrewMatching;

	// 페어 매칭 첫번째 화면
	public static void mathingStart() {
		Output.pairMatching();
		while (true) {
			try {
				String inputString = Input.pairMatching();
				Stringdivide(inputString);
				break;
			} catch (IllegalArgumentException e) {
				// 에러메시지
				System.out.println();
			}
		}
		shuffleCrew();
		crewTotalNumber();
		// 이미 페어를 맺은 크루가 있는 지 체크

	}

	// 크루들 셔플하기
	public static void shuffleCrew() {
		shuffledCrew = Randoms.shuffle(CrewNames);
		System.out.println(shuffledCrew);
	}

	// 크루 2명씩 매칭
	public static void pairMatching(int crewSize) {
		for (int index = 0; index < crewSize; index += 2) {
			Crew matchingCrew = new Crew(shuffledCrew.get(index), shuffledCrew.get(index));
			CrewMatching.add(matchingCrew);
		}
	}

	// 크루 3명 매칭
	public static void pairthreeMatching() {
		int index = shuffledCrew.size() - 1;
		Crew matchingCrew = new Crew(shuffledCrew.get(index - 2), shuffledCrew.get(index - 1), shuffledCrew.get(index));
		CrewMatching.add(matchingCrew);

	}

	// 크루 총인원 체크
	public static void crewTotalNumber() {
		if (shuffledCrew.size() % 2 == 0) {
			pairMatching(shuffledCrew.size()); // 짝수면 두명씩 매칭 가능
		}
		if (shuffledCrew.size() % 2 != 0) {
			pairMatching(shuffledCrew.size()-3);
			pairthreeMatching(); // 홀수면 마지막 세명이 매칭
		}
		
	}

	// 입력받은값 3개로 분류하기
	private static void Stringdivide(String input) {
		String[] threeSelct = input.split(",");
		checkPart(threeSelct[0]);
		matchLevel = checkLevel(threeSelct[1]);
		matchMission = checkMission(matchLevel, threeSelct[2]);
	}

	// 프론트/백 체크
	private static void checkPart(String part) {
		if (part.equals(Course.BACKEND.getCourse())) {
			matchCourse = Course.BACKEND;
			CrewNames = FileReading.backCrewReading();
		}
		if (part.equals(Course.FRONTEND.getCourse())) {
			matchCourse = Course.FRONTEND;
			CrewNames = FileReading.frontCrewReading();
		}
		// 에러메시지
		throw new IllegalArgumentException();
	}

	// 레벨체크
	private static Level checkLevel(String level) {
		for (Level stage : Level.values()) {
			if (stage.getLevel().equals(level)) {
				return stage;
			}
		}
		// 에러메시지
		throw new IllegalArgumentException();
	}

	// 미션 체크
	private static String checkMission(Level level, String mission) {
		ArrayList<String> missionList = level.getMission();
		for (String m : missionList) {
			if (m.equals(mission)) {
				return mission;
			}
		}
		// 에러메시지
		throw new IllegalArgumentException();
	}
}
