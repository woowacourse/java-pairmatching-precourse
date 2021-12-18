package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domains.programfunc.ProgramSelection;

public class InputView {

	public static ProgramSelection getUserSelect() {
		String userSelection = Console.readLine();
		ProgramSelection selection = ProgramSelection.findBySelection(userSelection);
		return selection;
	}
}
