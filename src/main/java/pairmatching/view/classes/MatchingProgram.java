package pairmatching.view.classes;

import static pairmatching.constant.PromptConstants.*;

import pairmatching.model.ProgramStatus;
import pairmatching.view.MatchingProgramInterface;

public class MatchingProgram implements MatchingProgramInterface {
	ProgramStatus programStatus = ProgramStatus.SHOW_FUNCTIONS;
	@Override
	public void start() {
		while(true) {
			if (programStatus == ProgramStatus.SHOW_FUNCTIONS) {
				System.out.println(ASK_FUNCTION_PROMPT);
				System.out.println(ASK_FUNCTION_LIST_PROMPT);
				break;
			}
		}
	}
}
