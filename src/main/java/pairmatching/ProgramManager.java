package pairmatching;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class ProgramManager {

	public static boolean selectFunction(){
		//ProgramPrinter.selectFunction();
		String selection = Console.readLine();

		if(selection == "1"){
			//PairMatcher.pairMatch();
		} else if(selection == "2"){
			ProgramManager.lookUpPair();
		} else if(selection == "3"){
			ProgramManager.initializePair();
		} else if(selection == "Q"){
			return true;
		}

		return false;
	}

	public static void lookUpPair(Course course, Level level, String mission){
		List<PairMatchRecorder> checkList = ProgramData.getMatchingHistory(course, level);

		for(PairMatchRecorder history : checkList){
			if(!history.isMatchedMission(mission)){
				//ProgramPrinter.printPair();
				return;
			}
		}

		System.out.println("[ERROR] 매칭 이력이 없습니다.");
		return;
	}

	public static void initializePair(){
		ProgramData.deleteMatchingHistory();
	}
}
