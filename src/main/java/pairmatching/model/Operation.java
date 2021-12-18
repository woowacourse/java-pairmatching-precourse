package pairmatching.model;

import java.util.List;

import pairmatching.controller.DomainController;
import pairmatching.controller.FunctionController;
import pairmatching.view.DomainMessage;
import pairmatching.view.FunctionMessage;

public class Operation {
	public static String selectFunction() {
		FunctionMessage.printManual();
		return FunctionController.getFunction();
	}

	public static List<String> selectDomain() {
		DomainMessage.printManual();
		return DomainController.getDomains();
	}

	public static void execute(String function, List<String> domainList, List<String> crews) {
		if (function.equals("1")) {
			MatchingService.start(domainList, crews);
		}
		if (function.equals("2")) {
			LookUpService.start(domainList);
		}
		if (function.equals("3")) {
			CleanUpService.start(domainList);
		}
		if (function.equals("Q")) {
			return;
		}
	}
}
