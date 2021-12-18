package pairmatching.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.LevelGroup;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatching;
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
			makePairMatching();
		}
		if (function.equals(Constant.FUNCTION_PAIR_LOOKUP)) {
			makePairMatching();
		}
		if (function.equals(Constant.FUNCTION_PAIR_INITIALIZATION)) {
			OutputView.printInitialization();
			pairMatchings.initialization();
		}
		return !function.equals(Constant.FUNCTION_EXIT);
	}

	public PairMatching makePairMatching() {
		List<String> pairMatching = runPairMatching();

		return new PairMatching(Course.fromString(pairMatching.get(0)), Level.fromString(pairMatching.get(1)),
			Mission.fromString(pairMatching.get(2)));
	}

	public List<String> runPairMatching() {
		try {
			OutputView.printCourseAndMission();
			return getPairMatching();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return runPairMatching();
		}
	}

	public List<String> getPairMatching() {
		List<String> pairMatching = Arrays.stream(InputView.getPairMathing().split(Constant.SPLIT))
			.collect(Collectors.toList());
		if (pairMatching.size() != Constant.INPUT_SIZE) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_COURSE_AND_MISSION);
		}
		if (Arrays.stream(Course.values())
			.noneMatch(e -> e.getName().equals(pairMatching.get(Constant.COURSE_INDEX)))) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_COURSE_NONE);
		}
		if (Arrays.stream(Level.values()).noneMatch(e -> e.getName().equals(pairMatching.get(Constant.LEVEL_INDEX)))) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_LEVEL_NONE);
		}
		if (Arrays.stream(Mission.values())
			.noneMatch(e -> e.getName().equals(pairMatching.get(Constant.MISSION_INDEX)))) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_MISSION_NONE);
		}
		LevelGroup levelGroup = LevelGroup.findGroup(pairMatching.get(Constant.LEVEL_INDEX));
		if (!LevelGroup.hasMission(levelGroup, Mission.fromString(pairMatching.get(Constant.MISSION_INDEX)))) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_LEVEL_MISSION_NONE_MATCH);
		}
		return pairMatching;
	}

}
