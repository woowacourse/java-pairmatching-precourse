package pairmatching;

import java.util.Arrays;
import java.util.List;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.MatchObjective;
import pairmatching.domain.Mission;
import pairmatching.exception.MatchFailException;
import pairmatching.service.CrewService;
import pairmatching.service.MatcherService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatcherController {

	private MatcherService matcherService;
	private CrewService crewService;

	public MatcherController() {
		this.matcherService = new MatcherService();
		this.crewService = new CrewService();
	}

	public MatchObjective requestMatchInfo() {
		String input = InputView.inputMatchInfo();
		List<String> infoList = Arrays.asList(input.split(", ", -1));
		return new MatchObjective(Course.ofName(infoList.get(0)), Level.ofName(infoList.get(1)), infoList.get(2));
	}

	public String requestFunctionNumber() {
		return InputView.inputFunctionNumber();
	}

	public Mission match(MatchObjective matchObjective) {
		try {
			return matcherService.match(matchObjective, 0);
		} catch (MatchFailException e) {
			System.out.println("매칭에 실패했습니다. 메인으로 돌아갑니다.");
			return null;
		}
	}

	public boolean operateLoop() {
		String input = requestFunctionNumber();
		if (input.equals("1")) {
			Mission mission = match(requestMatchInfo());
			if (mission != null)
				OutputView.printMatchInfo(mission);
			return true;
		}
		if (input.equals("2")) {
			MatchObjective matchObjective = requestMatchInfo();
			return true;
		}
		return false;
	}

	public void operate() {
		while (operateLoop())
			;
	}
}
