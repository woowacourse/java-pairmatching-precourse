package pairmatching.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class MainController {
	static final String MISSION_INPUT_REGEX = ",";
	static final int MISSION_INPUT_COUNT = 3;
	static final String ERROR_MISSION_INPUT_COUNT = "과정, 레벨, 미션을 모두 입력해주세요.";

	public MainController() {
		InitializeController.initCrews();
	}

	public void run() {
		Option option;
		do {
			Output.mainOption();
			option = getOption();
			runOption(option);
		} while (!option.equals(Option.QUIT));
	}

	private Option getOption() {
		Option option;
		do {
			try {
				option = Option.getByValue(Input.readLine());
				break;
			} catch (IllegalArgumentException e) {
				Output.printError(e.getMessage());
			}
		} while (true);

		return option;
	}

	private void runOption(Option option) {
		do {
			try {
				selectOption(option);
				break;
			} catch (IllegalArgumentException e) {
				Output.printError(e.getMessage());
			}
		} while (true);
	}

	private void selectOption(Option option) {
		if (option.equals(Option.MATCH)) {
			Mission mission = getMission();
			MatchingController.run(mission);
		}
		if (option.equals(Option.CHECK)) {
			Mission mission = getMission();

		}
		if (option.equals(Option.INIT)) {

		}
	}

	private Mission getMission() {
		Output.missionInfo();
		List<String> missionInput
			= Arrays.asList(Input.readLine().split(MISSION_INPUT_REGEX));
		validateMissionInput(missionInput);
		return MissionRepository.getMission(missionInput.stream()
			.map(String::trim)
			.collect(Collectors.toList()));
	}

	private static void validateMissionInput(List<String> missionInput) {
		if (missionInput.size() != MISSION_INPUT_COUNT) {
			throw new IllegalArgumentException(ERROR_MISSION_INPUT_COUNT);
		}
	}
}
