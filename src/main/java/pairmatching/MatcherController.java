package pairmatching;

import java.util.Arrays;
import java.util.List;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.domain.MatchObjective;
import pairmatching.repository.CrewRepository;
import pairmatching.service.CrewService;
import pairmatching.service.MatcherService;
import pairmatching.view.InputView;

public class MatcherController {

	private MatcherService matcherService;
	private CrewService crewService;
	private CrewRepository crewRepository;

	public MatcherController(MatcherService matcherService, CrewService crewService,
		CrewRepository crewRepository) {
		this.matcherService = matcherService;
		this.crewService = crewService;
		this.crewRepository = crewRepository;
	}

	public MatchObjective requestMatchInfo() {
		String input = InputView.inputMatchInfo();
		List<String> infoList = Arrays.asList(input.split(", ", -1));

		return new MatchObjective(Course.valueOf(infoList.get(0)), Level.valueOf(infoList.get(1)), infoList.get(2));
	}

	public String requestFunctionNumber() {
		String input = InputView.inputFunctionNumber();
		return input;
	}
}
