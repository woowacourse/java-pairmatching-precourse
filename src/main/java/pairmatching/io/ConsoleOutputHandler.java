package pairmatching.io;

import java.util.ArrayList;
import java.util.List;

import pairmatching.data.ProgramData;
import pairmatching.type.Crew;
import pairmatching.type.PairLog;

public class ConsoleOutputHandler {
	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printErrorMessage(Exception exception) {
		printMessage(exception.getMessage());
	}

	public void printPairInformation(PairLog pairLog) {
		printMessage(ProgramData.PAIR_MATCH_RESULT_MESSAGE);
		for(List<Crew> pair:pairLog.getPairResult()) {
			List<String> crewNames = new ArrayList<String>();
			for(Crew crew:pair) {
				crewNames.add(crew.toString());
			}
			printMessage(String.join(ProgramData.PAIR_SEPARATOR, crewNames));
		}
	}
}
