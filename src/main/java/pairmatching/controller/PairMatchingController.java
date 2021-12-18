package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.PairMatchings;
import pairmatching.util.Constant;
import pairmatching.util.CrewParse;
import pairmatching.util.ErrorMessage;
import pairmatching.util.FileInput;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	public void start() {
		List<Crew> crewList = new ArrayList<>();
		crewList.addAll(CrewParse.make(Course.BACKEND, FileInput.input(Constant.backendCrewFileName)));
		crewList.addAll(CrewParse.make(Course.FRONTEND, FileInput.input(Constant.frontendCrewFileName)));
		Crews crews = new Crews(crewList);
		PairMatchings pairMatchings = new PairMatchings();

		while (runFunction(pairMatchings)) {

		}
	}

	public boolean runFunction(PairMatchings pairMatchings) {
		String function = "";
		try {
			function = getFunction();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			runFunction(pairMatchings);
		}
		return selectFunction(function, pairMatchings);
	}

	public String getFunction() {

		String function = InputView.getFunction();
		if (function.equals(Constant.FUNCTION_PAIR_MATCHING) || function.equals(Constant.FUNCTION_PAIR_LOOKUP)
			|| function.equals(Constant.FUNCTION_PAIR_INITIALIZATION) || function.equals(Constant.FUNCTION_EXIT)) {
			return function;
		}

		throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_FUNCTION_NONE);
	}

	public boolean selectFunction(String function, PairMatchings pairMatchings) {
		if (function.equals(Constant.FUNCTION_PAIR_MATCHING)) {

		}
		if (function.equals(Constant.FUNCTION_PAIR_LOOKUP)) {

		}
		if (function.equals(Constant.FUNCTION_PAIR_INITIALIZATION)) {
			pairMatchings.initialization();
		}
		return !function.equals(Constant.FUNCTION_EXIT);
	}
}
