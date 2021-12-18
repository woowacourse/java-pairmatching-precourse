package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Application;
import pairmatching.controller.ViewMappingKey;
import pairmatching.util.SystemMessage;

public class FunctionSelectView implements View {
	@Override
	public void flow() {
		String option = readOption();
		boolean isExit = exactOption(option);
		if (isExit) {
			printExit();
			return;
		}
		reshow();
	}

	@Override
	public void printViewMessage() {
		System.out.println(SystemMessage.FUNCTION_SELECT);
	}

	private String readOption() {
		return Console.readLine();
	}

	private boolean exactOption(String option) {
		if (option.equals("1")) {
			Application.controller.view(ViewMappingKey.PAIR_MATCHING_INPUT);
			return true;
		}
		if (option.equals("2")) {
			Application.controller.view(ViewMappingKey.PAIR_MATCHING_SEARCH);
			return true;
		}
		if (option.equals("3")) {
			Application.controller.view(ViewMappingKey.PAIR_RESET);
			return true;
		}
		return option.equals("Q");
	}

	private void printExit() {
		System.out.println(SystemMessage.EXIT);
	}

	public void reshow() {
		Application.controller.view(ViewMappingKey.FUNCTION_SELECT);
	}
}
