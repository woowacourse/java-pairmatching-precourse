package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.exception.DuplicatedCrewNameException;
import pairmatching.exception.NotFoundFunctionOptionException;
import pairmatching.model.CrewNameReader;
import pairmatching.model.CrewRepository;
import pairmatching.model.FunctionOption;
import pairmatching.view.InputView;

public class CrewMatchingController {
	private CrewRepository frontendCrews;
	private CrewRepository backendCrews;

	public void start() {
		setupCrewInfo();
		boolean isRunning = true;

		while (isRunning) {
			InputView.printFunctionOptions();
			FunctionOption functionOptionFromClient = getFunctionOptionFromClient();
			isRunning = operateByFunction(functionOptionFromClient, isRunning);
		}
	}

	private boolean operateByFunction(FunctionOption functionOptionFromClient, boolean isRunning) {
		if (functionOptionFromClient.equals(FunctionOption.EXIT)) {
			return false;
		}

		InputView.printCourseInfo();

		return true;
	}

	private FunctionOption getFunctionOptionFromClient() {
		try {
			return FunctionOption.of(Console.readLine());
		} catch (NotFoundFunctionOptionException e) {
			System.out.println(e.getMessage());
			return getFunctionOptionFromClient();
		}
	}

	private void setupCrewInfo() {
		try {
			frontendCrews = new CrewRepository(CrewNameReader.getFrontendCrewNameList());
			backendCrews = new CrewRepository(CrewNameReader.getBackendCrewNameList());
		} catch (DuplicatedCrewNameException e) {
			System.out.println(e.getMessage());
		}
	}
}
