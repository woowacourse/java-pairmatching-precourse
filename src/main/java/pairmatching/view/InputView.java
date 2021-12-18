package pairmatching.view;

import static pairmatching.constant.ViewMessage.*;

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

	public static String printShuffleMessage() {
		System.out.println(IS_ALREADY_SHUFFLED);
		System.out.println(YES_MESSAGE
			+ STATE_DIVIDER

			+ NO_MESSAGE);
		return Console.readLine();
	}
}
