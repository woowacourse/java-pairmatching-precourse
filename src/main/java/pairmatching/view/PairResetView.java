package pairmatching.view;

import pairmatching.Application;
import pairmatching.controller.ViewMappingKey;
import pairmatching.util.SystemMessage;

public class PairResetView implements View {
	@Override
	public void flow() {
		resetPair();
		goFunctionSelect();
	}

	@Override
	public void printViewMessage() {
		System.out.println();
		System.out.println(SystemMessage.RESET);
	}

	private void resetPair() {
		Application.controller.resetPairs();
	}

	private void goFunctionSelect() {
		Application.controller.view(ViewMappingKey.FUNCTION_SELECT);
	}
}
