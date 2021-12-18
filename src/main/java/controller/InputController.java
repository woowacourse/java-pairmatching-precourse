package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import utils.validator.FunctionSelectionNumberValidator;
import utils.validator.LevelValidator;
import utils.validator.MissionValidator;
import utils.validator.ProcessValidator;

public class InputController {

	private InputController() {
	}

	public static String inputFunctionSelectionNumber() {
		while (true) {
			try {
				return FunctionSelectionNumberValidator.checkValidNumber(Console.readLine());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public static List<String> inputProcessAndLevelAndMission() {
		while (true) {
			try {
				return checkProcessAndLevelAndMission(Console.readLine());
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private static List<String> checkProcessAndLevelAndMission(String processAndLevelAndMission) {
		List<String> processInformation = Arrays.stream(processAndLevelAndMission.split(","))
			.map(String::trim)
			.collect(Collectors.toList());
		if (isThreeInformationInProcessInformation(processInformation) && ProcessValidator.isValidProcess(
			processInformation.get(0)) && LevelValidator.isValidLevel(processInformation.get(1))
			&& MissionValidator.isValidMission(processInformation.get(1), processInformation.get(2))) {
			return processInformation;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isThreeInformationInProcessInformation(List<String> processInformation) {
		if (processInformation.size() != 3) {
			throw new IllegalArgumentException("[ERROR] 입력한 정보가 3개(과정, 레벨, 미션)가 아니다.");
		}
		return true;
	}
}
