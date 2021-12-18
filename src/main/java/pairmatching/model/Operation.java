package pairmatching.model;

import pairmatching.controller.FunctionController;
import pairmatching.view.FunctionMessage;

public class Operation {
	public static void start() {
		FunctionMessage.printManual();
		String function = FunctionController.getFunction();
	}
}
