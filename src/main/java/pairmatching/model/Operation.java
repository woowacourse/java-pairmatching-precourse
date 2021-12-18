package pairmatching.model;

import java.util.List;

import pairmatching.controller.DomainController;
import pairmatching.controller.FunctionController;
import pairmatching.view.DomainMessage;
import pairmatching.view.FunctionMessage;

public class Operation {
	public static void start() {
		FunctionMessage.printManual();
		String function = FunctionController.getFunction();

		DomainMessage.printManual();
		List<String> DomainList = DomainController.getDomains();
	}
}
