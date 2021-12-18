package pairmatching;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class Matching {
	static List<Pair> PairList;
	static List<String> CrewNames;
	static List<String> shuffledCrew;
	static List<Crew> CrewMatching;
	
	
	
	
	// 페어 매칭 첫번째 화면
	public static void mathingStart() {
		Output.pairMatching();
		Pair validList;
		while (true) {
			try {
				String inputString = Input.pairMatching();
				validList = ValidCheck.Stringdivide(inputString);
				break;
			} catch (IllegalArgumentException e) {
				// 에러메시지
				System.out.println("[ERROR]");
			}
		}
		//크루 불러오기 
		CrewNames = Course.crewLoad(validList.getCourse());
		shuffleCrew();
		crewTotalNumber();
		Output.resultPrint(CrewMatching);
		
		// 이미 페어를 맺은 크루가 있는 지 체크
		PairList.add(validList);
		
	}
	// 페어 조회 첫번째 화면
	public static void searchingStart() {
		Output.pairMatching();
		Pair validList;
		while (true) {
			try {
				String inputString = Input.pairMatching();
				validList = ValidCheck.Stringdivide(inputString);
				break;
			} catch (IllegalArgumentException e) {
				// 에러메시지
				System.out.println("[ERROR]");
			}
			

		}
		searchingPair(validList);
		
	
	}
	
	//조회 
	static void searchingPair(Pair searchPair){
		for(Pair makePair:PairList) {
			if(makePair.equals(searchPair)) {
				//출력 pair
			}
		}
	}
	//초기화
	static void cleanPair() {
		PairList = null;
		//초기화 출력 
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
	


}
