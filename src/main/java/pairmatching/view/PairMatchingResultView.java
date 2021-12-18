package pairmatching.view;

import pairmatching.Application;
import pairmatching.controller.ViewMappingKey;
import pairmatching.util.SystemMessage;

public class PairMatchingResultView implements View {
	@Override
	public void flow() {
		Application.controller.view(ViewMappingKey.FUNCTION_SELECT);
	}

	@Override
	public void printViewMessage() {
		System.out.println(SystemMessage.MATCHING_RESULT);
		String matchResult = Application.controller.getMatchResult();
		System.out.println(matchResult);
	}
}
