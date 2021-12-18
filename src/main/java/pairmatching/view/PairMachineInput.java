package pairmatching.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.models.Mission;
import pairmatching.utils.PairMatchingMessage;

public class PairMachineInput {

	public String selectFunction() {
		PairMatchingMessage.printInputFunction();
		return Console.readLine();
	}

	public String selectCourseAndMission(final List<String> courses,
			final List<Mission> missions) {
		PairMatchingMessage.printChooseMission(courses, missions);
		return Console.readLine();
	}

	public String selectRematchPairOrNot() {
		PairMatchingMessage.printRematchingPair();
		return Console.readLine();
	}
}
