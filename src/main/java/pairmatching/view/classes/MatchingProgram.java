package pairmatching.view.classes;

import static camp.nextstep.edu.missionutils.Console.*;
import static pairmatching.constant.PromptConstants.*;

import pairmatching.constant.FunctionStatus;
import pairmatching.constant.ProgramStatus;
import pairmatching.controller.FunctionSelector;
import pairmatching.view.MatchingProgramInterface;

public class MatchingProgram implements MatchingProgramInterface {
	ProgramStatus programStatus = ProgramStatus.SHOW_FUNCTIONS;
	FunctionStatus functionStatus;
	FunctionSelector functionSelector = new FunctionSelector();
	@Override
	public void start() {
		while(true) {
			if (programStatus == ProgramStatus.SHOW_FUNCTIONS) {
				System.out.println(ASK_FUNCTION_PROMPT);
				System.out.println(ASK_FUNCTION_LIST_PROMPT);
				programStatus = ProgramStatus.SELECT_FUNCTION;
			}
			if (programStatus == ProgramStatus.SELECT_FUNCTION) {
				String inputFunction = readLine();
				if (functionSelector.getByString(inputFunction) == FunctionStatus.PAIR_MATCHING) {
					programStatus = ProgramStatus.SHOW_PAIR_MATCHING_BOARD_FOR_MATCHING;
				}
				if (functionSelector.getByString(inputFunction) == FunctionStatus.PAIR_SEARCH) {
					programStatus = ProgramStatus.SHOW_PAIR_MATCHING_BOARD_FOR_SEARCHING;
				}
				if (functionSelector.getByString(inputFunction) == FunctionStatus.PAIR_CLEAR) {
					programStatus = ProgramStatus.SHOW_PAIR_CLEAN;
				}
				if (functionSelector.getByString(inputFunction) == FunctionStatus.EXIT) {
					break;
				}
				if (functionSelector.getByString(inputFunction) == FunctionStatus.INVALID_INPUT) {
					break;
				}
			}

			if (programStatus == ProgramStatus.SHOW_PAIR_MATCHING_BOARD_FOR_MATCHING) {
				System.out.println("matching");
				break;
			}

			if (programStatus == ProgramStatus.SHOW_PAIR_MATCHING_BOARD_FOR_SEARCHING) {
				System.out.println("search");
				break;
			}

			if (programStatus == ProgramStatus.SHOW_PAIR_CLEAN) {
				System.out.println("clean");
				break;
			}
		}
	}
}
