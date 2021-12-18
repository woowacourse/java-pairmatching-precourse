package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domains.mission.Mission;
import pairmatching.domains.mission.Missions;
import pairmatching.domains.programfunc.ProgramSelection;
import pairmatching.exceptions.UserInputException;

public class InputView {

	public static ProgramSelection getUserSelect() {
		String userSelection = Console.readLine();
		ProgramSelection selection = ProgramSelection.findBySelection(userSelection);
		return selection;
	}

	public static Mission getUserMission(Missions missions) {
		String userMission = Console.readLine();
		UserInputException.isMission(userMission);
		return missions.findMissionByInput(userMission);
	}
}
