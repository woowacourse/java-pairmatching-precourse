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
		InputView.printFunctionOptions();
		FunctionOption functionOptionFromClient = getFunctionOptionFromClient();
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
