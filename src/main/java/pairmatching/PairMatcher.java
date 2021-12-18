package pairmatching;

import java.util.HashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class PairMatcher {
	private static final int MAX_NUMBER_OF_ATTEMPT = 3;

	public static void pairMatch(Course course, Level level, String mission) throws  IllegalArgumentException{
		List<String> crewNames = ProgramData.getCrewNames(course);
		List<String> shuffledNames = Randoms.shuffle(crewNames);
		List<PairMatchRecorder> checkList = ProgramData.getMatchingHistory(course, level);
		boolean match = true;
		ProgramPrinter.printMission();
		ProgramPrinter.printSelectLine();

		for(PairMatchRecorder history : checkList){
			if(!history.isMatchedMission(mission)){
				match = askToRematch();
			}
		}

		if(match == true) {
			validatePairMatch(checkList, shuffledNames);
			ProgramData.setMatchingHistory(course, level, mission, shuffledNames);
			ProgramPrinter.printPairInfo(shuffledNames);
		}
	}

	private static boolean askToRematch(){
		ProgramPrinter.printAskToRematch();
		String response = Console.readLine();

		if(response == "아니오"){
			return false;
		}

		return true;
	}

	private static void validatePairMatch(List<PairMatchRecorder> checkList, List<String> shuffledNames){
		int numberOfAttempt = 0;
		boolean validate = false;

		while(numberOfAttempt < MAX_NUMBER_OF_ATTEMPT || validate == true){
			for(PairMatchRecorder history : checkList){
				validate = history.checkDuplicatedPair(shuffledNames);
				numberOfAttempt++;
			}
		}

		if(numberOfAttempt == 3){
			throw new IllegalArgumentException("[ERROR] 3회 시도까지 매칭이 되지 않았습니다.");
		}

		return;
	}
}
