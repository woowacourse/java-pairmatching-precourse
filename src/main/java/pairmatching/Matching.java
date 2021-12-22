package pairmatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Matching {
	static List<String> CrewNames;
	static List<String> shuffledCrew;
	static ArrayList<Pair> linkPair= new ArrayList<>(); 
	static ArrayList<ArrayList<ArrayList<String>>> linkCrew = new ArrayList<>();
	static String errorMessage;

	public static void matchingHashMap() {

		Pair pair = matchingStart();
		CrewNames = Course.crewLoad(pair.getCourse());
		shuffleCrew();
		ArrayList<ArrayList<String>> CrewMatching = new ArrayList<>();
		CrewMatching = crewTotalNumber();
		Output.resultPrint(CrewMatching);
		linkPair.add(pair);
		linkCrew.add(CrewMatching);
	}

	// 페어 매칭전 값 확인
	private static Pair matchingStart() {
		Output.pairMatching();
		while (true) {
			Pair validList = ValidCheck.stringDivide();
			int index = searchingPair(validList);
			
			if (index < 0 ) {// 중복되는 값이 아닌 경우
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
		if (index < 0 ) {// 조회할 값이 없는 경우
			errorMessage = "[ERROR] 매칭 이력이 없습니다.";
			throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
		}
		//조회할 값이 있는 경우 
		Output.resultPrint(linkCrew.get(index));

	}
		
	
	// 조회
	static int searchingPair(Pair searchPair) {
		for (Pair makePair : linkPair) {
			if (makePair.getCourse().equals(searchPair.getCourse()) && makePair.getLevel().equals(searchPair.getLevel())
					&& makePair.getMission().equals(searchPair.getMission())) {
				int index = linkPair.indexOf(makePair); //조회된 곳 인덱스
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
	public static void shuffleCrew() {
		shuffledCrew = Randoms.shuffle(CrewNames);
	}

	// 크루 2명씩 매칭
	private static void pairMatching(int crewListSize, ArrayList<ArrayList<String>> crewMatching) {
		for (int index = 0; index < crewListSize; index += 2) {
			ArrayList<String> twoCrew = new ArrayList<>();
			twoCrew.add(shuffledCrew.get(index));
			twoCrew.add(shuffledCrew.get(index + 1));
			crewMatching.add(twoCrew);
		}
	}

	// 크루 3명 매칭
	public static void pairthreeMatching(ArrayList<ArrayList<String>> crewMatching) {
		int index = shuffledCrew.size() - 1;
		ArrayList<String> threeCrew = new ArrayList<>();
		threeCrew.add(shuffledCrew.get(index - 2));
		threeCrew.add(shuffledCrew.get(index - 1));
		threeCrew.add(shuffledCrew.get(index));
		crewMatching.add(threeCrew);
	}

	// 크루 총인원 체크
	public static ArrayList<ArrayList<String>> crewTotalNumber() {
		ArrayList<ArrayList<String>> CrewMatching = new ArrayList<>();

		if (shuffledCrew.size() % 2 == 0) {
			pairMatching(shuffledCrew.size(), CrewMatching); // 짝수면 두명씩 매칭 가능
		}
		if (shuffledCrew.size() % 2 != 0) {
			pairMatching(shuffledCrew.size() - 3, CrewMatching);
			pairthreeMatching(CrewMatching); // 홀수면 마지막 세명이 매칭
		}
		return CrewMatching;
	}

}
