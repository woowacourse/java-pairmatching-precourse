package pairmatching.view;

import pairmatching.Application;
import pairmatching.controller.ViewMappingKey;
import pairmatching.util.SystemMessage;

public class PairResetView implements View {
	@Override
	public void flow() {
		Application.controller.resetPairs();
		Application.controller.view(ViewMappingKey.FUNCTION_SELECT);
	}

	@Override
	public void printViewMessage() {
		System.out.println();
		System.out.println(SystemMessage.RESET);
	}
}
