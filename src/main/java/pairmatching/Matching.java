package pairmatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import camp.nextstep.edu.missionutils.Randoms;

public class Matching {
	static List<String> CrewNames;
	static List<String> shuffledCrew;
	static HashMap<Pair,ArrayList> linkPairCrew = new  HashMap<>();
	
	
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
				// 옳바른 과정, 레벨, 미션값을 입력해주세요.
				System.out.println("[ERROR]");
			}
		}
		
		
		
		//크루 불러오기 
		CrewNames = Course.crewLoad(validList.getCourse());
		shuffleCrew();
		
		ArrayList<ArrayList<String>> CrewMatching= new ArrayList<>();
		CrewMatching = crewTotalNumber();
		Output.resultPrint(CrewMatching);
		
		linkPairCrew.put(validList, CrewMatching);
		
		// 이미 페어를 맺은 크루가 있는 지 체크
		
		
		System.out.println(linkPairCrew.keySet());
		System.out.println(CrewMatching);

		
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
	static boolean searchingPair(Pair searchPair){
		for(Pair makePair:linkPairCrew.keySet()) {
			if(makePair.getCourse().equals(searchPair.getCourse())&&
					makePair.getLevel().equals(searchPair.getLevel())&&
					makePair.getMission().equals(searchPair.getMission())){
						
				System.out.println(linkPairCrew.get(makePair)); //출력 수정필요
				return true;
			}
		}
		System.out.println("[ERROR] 매칭되지 않은 페어입니다.");
		throw new IllegalArgumentException("[ERROR] 매칭되지 않은 페어입니다.");
		
		
	}
	//초기화
	static void cleanPair() {
		linkPairCrew.clear();
		//초기화 출력 
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
			twoCrew.add(shuffledCrew.get(index+1));
			crewMatching.add(twoCrew);
		}
	}

	// 크루 3명 매칭
	public static void pairthreeMatching(ArrayList<ArrayList<String>> crewMatching) {
		int index = shuffledCrew.size() - 1;
		ArrayList<String> threeCrew = new ArrayList<>();
		threeCrew.add(shuffledCrew.get(index-2));
		threeCrew.add(shuffledCrew.get(index-1));
		threeCrew.add(shuffledCrew.get(index));
		crewMatching.add(threeCrew);
	}

	// 크루 총인원 체크
	public static ArrayList<ArrayList<String>> crewTotalNumber() {
		ArrayList<ArrayList<String>> CrewMatching= new ArrayList<>();
		
		if (shuffledCrew.size() % 2 == 0) {
			pairMatching(shuffledCrew.size(), CrewMatching); // 짝수면 두명씩 매칭 가능
		}
		if (shuffledCrew.size() % 2 != 0) {
			pairMatching(shuffledCrew.size()-3, CrewMatching);
			pairthreeMatching(CrewMatching); // 홀수면 마지막 세명이 매칭
		}
		return CrewMatching;
	}
	


}
