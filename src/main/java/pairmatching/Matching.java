package pairmatching;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Matching {

	static List<String> crewList = FileReading.backCrewReading();
	static ArrayList<String> three = new ArrayList<>();

	// 크루들 셔플하기
	public static void shuffleCrew() {
		List<String> shuffleList = Randoms.shuffle(crewList);
		System.out.println(shuffleList);
	}

	// 입력받은값 3개로 분류하기
	private void Stringdivide(String input) {
		String[] threeSelct = input.split(",");
		checkPart(threeSelct[0]);
		Level level = checkLevel(threeSelct[1]);
		String mission = checkMission(level, threeSelct[2]);
		
	}
	
	// 프론트/백 체크
	private void checkPart(String part) {
		if(part.equals(Course.BACKEND.getCourse())) {
			
		}
		if(part.equals(Course.FRONTEND.getCourse())){
			
		}
		// 에러메시지
		throw new IllegalArgumentException();
	}
	
	
	//레벨체크 
	private Level checkLevel(String level) {
		for(Level stage :Level.values()) {
			if(stage.getLevel().equals(level)) {
				return stage;
			}
		}
		// 에러메시지
		throw new IllegalArgumentException();
	}
	
	//미션 체크 
	private String checkMission(Level level, String mission) {
		ArrayList<String> missionList = level.getMission();
		for(String m : missionList) {
			if(m.equals(mission)) {
				return mission;
			}
		}
		// 에러메시지
		throw new IllegalArgumentException();
	}
}
