package pairmatching.view.classes;

import static camp.nextstep.edu.missionutils.Console.*;
import static pairmatching.constant.PromptConstants.*;

import java.io.FileNotFoundException;

import pairmatching.constant.CheckValidationCourseLevelMissionStatus;
import pairmatching.constant.FunctionStatus;
import pairmatching.constant.ProgramStatus;
import pairmatching.controller.CheckerValidationCourseLevelMissionInput;
import pairmatching.controller.FunctionSelector;
import pairmatching.controller.PairMaker;
import pairmatching.exception.InvalidFunctionSelectException;
import pairmatching.model.ProgramData;
import pairmatching.view.MatchingProgramInterface;

public class MatchingProgram implements MatchingProgramInterface {
	ProgramStatus programStatus = ProgramStatus.SHOW_FUNCTIONS;
	FunctionSelector functionSelector = new FunctionSelector();
	ProgramData programData;

	@Override
	public void start() {
		initProgramData();
		while(true) {
			if (proceedFunctionSelect())
				break;

			proceedShowPairMatchingBoardForMatching();
			if (programStatus == ProgramStatus.INPUT_COURSE_LEVEL_MISSION) {
				String inputCourseLevelMission = readLine();
				CheckerValidationCourseLevelMissionInput validationChecker = new CheckerValidationCourseLevelMissionInput(inputCourseLevelMission);
				if (validationChecker.checkValidation() == CheckValidationCourseLevelMissionStatus.VALID) {
					inputCourseLevelMission = inputCourseLevelMission.split(", ")[0] + inputCourseLevelMission.split(", ")[1] + inputCourseLevelMission.split(", ")[2];
					System.out.println(inputCourseLevelMission);
					if (programData.hasPair(inputCourseLevelMission)) {
						programStatus = ProgramStatus.ASKING_REMATCHING;
						continue;
					}
					PairMaker pairMaker = new PairMaker();
					pairMaker.make(programData.getBackendCrews());
					break;
				}
				if (validationChecker.checkValidation() == CheckValidationCourseLevelMissionStatus.INVALID_COURSE) {

				}
				if (validationChecker.checkValidation() == CheckValidationCourseLevelMissionStatus.INVALID_LEVEL) {

				}
				if (validationChecker.checkValidation() == CheckValidationCourseLevelMissionStatus.INVALID_MISSION) {

				}
				break;
			}

			if (programStatus == ProgramStatus.ASKING_REMATCHING) {
				System.out.println(ASKING_REMATCHING);
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

	private void proceedShowPairMatchingBoardForMatching() {
		if (programStatus == ProgramStatus.SHOW_PAIR_MATCHING_BOARD_FOR_MATCHING) {
			System.out.println(PAIR_MATCHING_BOARD);
			System.out.println(ASKING_COURSE_LEVEL_MISSION);
			programStatus = ProgramStatus.INPUT_COURSE_LEVEL_MISSION;
		}
	}

	private void initProgramData() {
		try {
			programData = new ProgramData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private boolean proceedFunctionSelect() {
		proceedShowFunctions();
		if (proceedSelectFunction())
			return true;
		return false;
	}

	private boolean proceedSelectFunction() {
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
				return true;
			}
			if (functionSelector.getByString(inputFunction) == FunctionStatus.INVALID_INPUT) {
				try {
					throw new InvalidFunctionSelectException();
				} catch (InvalidFunctionSelectException exception) {
					programStatus = ProgramStatus.SHOW_FUNCTIONS;

				}
			}
		}
		return false;
	}

	private void proceedShowFunctions() {
		if (programStatus == ProgramStatus.SHOW_FUNCTIONS) {
			System.out.println(ASK_FUNCTION_PROMPT);
			System.out.println(ASK_FUNCTION_LIST_PROMPT);
			programStatus = ProgramStatus.SELECT_FUNCTION;
		}
	}
}
