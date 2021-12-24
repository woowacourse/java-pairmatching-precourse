package pairmatching;

import java.util.ArrayList;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Matching {

	static ArrayList<Pair> linkPair = new ArrayList<>(); // 과정,레벨, 미션 저장하는곳
	static ArrayList<ArrayList<ArrayList<String>>> linkCrew = new ArrayList<>(); // 페어매칭 결과 저장하는 곳

	public static void matchingHashMap() {

		Pair pair = startMatching();
		List<String> CrewNames = Course.crewLoad(pair.getCourse());
		ArrayList<ArrayList<String>> CrewMatching = null;// null 로 바꿔보기
		int shuffleCount = 0;
		while (CrewMatching == null) {
			if (shuffleCount == 3) {// 3회시도 실패
				ValidCheck.threeTryError();
				return;
			}
			CrewNames = shuffleCrew(CrewNames);
			CrewMatching = crewTotalNumber(CrewNames, pair.getCourse(), pair.getLevel());
			shuffleCount += 1;
		}
		Output.resultPrint(CrewMatching);
		linkPair.add(pair);
		linkCrew.add(CrewMatching);
	}

	// 페어 매칭전 값 확인
	private static Pair startMatching() {
		Output.pairMatching();
		while (true) {
			Pair validList = ValidCheck.stringDivide();
			int index = searchingPair(validList);

			if (index < 0) {// 중복되는 값이 아닌 경우
				return validList;
			}
			String answer = Input.overWrite();
			if (answerCheck(answer.trim())) {// 덮어씌우기
				linkPair.remove(index);
				linkCrew.remove(index);
				return validList;
			}
		}

	}

	// 덮어씌우기 답변
	private static boolean answerCheck(String answer) {
		boolean overWrite = true;
		if (answer.equals("네")) {
			return overWrite;
		}
		return !overWrite;
	}

	// 페어 조회 화면
	public static void searchingStart() {
		Output.pairMatching();
		Pair validList = ValidCheck.stringDivide();
		int index = searchingPair(validList);
		if (index < 0) {// 조회할 값이 없는 경우
			try {
				throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		// 조회할 값이 있는 경우
		if (index > -1) {
			Output.resultPrint(linkCrew.get(index));
		}
	}

	// 조회
	static int searchingPair(Pair searchPair) {
		for (Pair makePair : linkPair) {
			if (makePair.getCourse().equals(searchPair.getCourse()) && makePair.getLevel().equals(searchPair.getLevel())
					&& makePair.getMission().equals(searchPair.getMission())) {
				int index = linkPair.indexOf(makePair); // 조회된 곳 인덱스
				return index;
			}
		}
		return -1;
	}

	// 초기화
	static void cleanPair() {
		linkPair.clear();
		linkCrew.clear();
		System.out.println("초기화되었습니다.");
		// 초기화 출력
	}

	// 크루들 셔플하기
	public static List<String> shuffleCrew(List<String> CrewNames) {
		return Randoms.shuffle(CrewNames);
	}

	// 크루 총인원 체크
	public static ArrayList<ArrayList<String>> crewTotalNumber(List<String> CrewNames, Course course, Level level) {
		ArrayList<ArrayList<String>> CrewMatching = new ArrayList<>();// 크루 명단 넣는값
		ArrayList<Integer> beforepairIndexs = beforePair(course, level);
		if (CrewNames.size() % 2 == 0) {
			if (!pairMatching(CrewNames, CrewNames.size(), CrewMatching, beforepairIndexs)) {
				return null;
			} // 짝수면 두명씩 매칭 가능
		}
		if (CrewNames.size() % 2 != 0) {
			if (!pairMatching(CrewNames, CrewNames.size() - 3, CrewMatching, beforepairIndexs)
					|| !pairthreeMatching(CrewNames, CrewMatching, beforepairIndexs)) {
				return null;
			} // 홀수면 마지막 세명이 매칭
		}
		return CrewMatching;
	}

	// 크루 2명씩 매칭
	private static boolean pairMatching(List<String> CrewNames, int crewListSize,
			ArrayList<ArrayList<String>> crewMatching, ArrayList<Integer> metBeforeList) {
		for (int index = 0; index < crewListSize; index += 2) {
			ArrayList<String> twoCrew = new ArrayList<>();
			twoCrew.add(CrewNames.get(index));
			twoCrew.add(CrewNames.get(index + 1));
			if (!metBeforeCheck(metBeforeList, twoCrew)) {
				crewMatching.clear();
				System.out.println("이미 매칭해본 페어입니다. ");
				return false;
			}
			;
			crewMatching.add(twoCrew);
		}
		return true;
	}

	// 크루 3명 매칭
	public static boolean pairthreeMatching(List<String> CrewNames, ArrayList<ArrayList<String>> crewMatching,
			ArrayList<Integer> metBeforeList) {
		int index = CrewNames.size() - 1;
		ArrayList<String> threeCrew = new ArrayList<>();
		threeCrew.add(CrewNames.get(index - 2));
		threeCrew.add(CrewNames.get(index - 1));
		threeCrew.add(CrewNames.get(index));
		if (!metBeforeCheck(metBeforeList, threeCrew)) {
			crewMatching.clear();
			System.out.println("이미 매칭해본 페어입니다. ");
			return false;
		}
		crewMatching.add(threeCrew);
		return true;
	}

	private static ArrayList<Integer> beforePair(Course course, Level level) {
		ArrayList<Integer> indexList = new ArrayList<>();
		for (Pair makePair : linkPair) {
			if (makePair.getCourse().equals(course) && makePair.getLevel().equals(level)) {
				int index = linkPair.indexOf(makePair); // 조회된 곳 인덱스
				indexList.add(index);
			}
		}
		return indexList;
	}

	private static boolean metBeforeCheck(ArrayList<Integer> BeforepairIndexs, ArrayList<String> crews) {
		for (int index : BeforepairIndexs) {
			if (crews.size() == 2) {
				return metBeforeCheck(index, crews, 2);
			}
			if (crews.size() == 3) {
				return metBeforeCheck(index, crews, 3);
			}
		}

		return true;

	}

	private static boolean metBeforeCheck(int BeforepairIndex, ArrayList<String> crews, int size) {
		for (ArrayList<String> beforePair : linkCrew.get(BeforepairIndex)) {
			if (size == 2 && beforePair.containsAll(crews)) {
				return false;
			}
			if (size == 3 && crews.containsAll(beforePair)) {
				return false;
			}
		}
		return true;

	}

}
