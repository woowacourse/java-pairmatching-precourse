package pairmatching.controller;

import pairmatching.domain.crew.BackendCrews;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.crew.FrontendCrews;
import pairmatching.exception.AlreadyExistPairException;
import pairmatching.service.CrewService;
import pairmatching.service.MatchingService;
import pairmatching.utils.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	private static final String BACKEND_CREW = "/backend-crew.md";
	private static final String FRONTEND_CREW = "/frontend-crew.md";
	private static final String BACKEND = "백엔드";

	private static final int FIRST_FUNCTION_NUMBER = 1;
	private static final int SECOND_FUNCTION_NUMBER = 2;
	private static final int MAX_FUNCTION_NUMBER = 3;

	private static CrewService crewService;
	private final MatchingService matchingService;

	public MatchingController() {
		crewService = new CrewService(new BackendCrews(BACKEND_CREW), new FrontendCrews(FRONTEND_CREW));
		matchingService = new MatchingService();
	}

	public Crews getRightCrews(String crewType) {
		if (crewType.equals(BACKEND)) {
			return getShuffledBackendCrews();
		}
		return getShuffledFrontendCrews();
	}

	private BackendCrews getShuffledBackendCrews() {
		return crewService.getShuffledBackendCrews();
	}

	private FrontendCrews getShuffledFrontendCrews() {
		return crewService.getShuffledFrontendCrews();
	}

	public void start() {
		String input = InputView.chooseFunction();
		try {
			Validator.validateFunctionNumber(input);
			if (input.equals("Q")) {
				return;
			}
			chooseFunction(Integer.parseInt(input));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			start();
		}
	}

	private void chooseFunction(int number) {
		if (number == FIRST_FUNCTION_NUMBER) {
			matching();
			return;
		}
		if (number == SECOND_FUNCTION_NUMBER) {
			return;
		}
		if (number == MAX_FUNCTION_NUMBER) {
		}
	}

	private void matching() {
		try {
			String[] input = InputView.printProgramInformation().split(",");
			Validator.validateCourseLevelMission(input);
			matchPair(input);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			matching();
		}
	}

	private void matchPair(String[] input) {
		try {
			String course = input[0].trim();
			String level = input[1].trim();
			String mission = input[2].trim();
			Crews crews = getRightCrews(course);
			matchingService.matchPair(crews, level, mission);
		} catch (AlreadyExistPairException e) {
			matchPair(input);
		}
	}
}
