package pairmatching;

import java.util.HashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class PairMatcher {
	private static final int MAX_NUMBER_OF_ATTEMPT = 3;

	public static void pairMatch(Course course, Level level, String mission) throws  IllegalArgumentException{
		List<String> crewNames = ProgramData.getCrewNames(course);
		List<String> shuffledNames = Randoms.shuffle(crewNames);

		List<PairMatchRecorder> checkList = ProgramData.getMatchingHistory(course, level);
		validatePairMatch(checkList, shuffledNames);
		ProgramData.setMatchingHistory(course, level, mission, shuffledNames);

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
