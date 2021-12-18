package utils.validator;

import java.util.List;

public class ProcessAndLevelAndMissionValidator {

	private ProcessAndLevelAndMissionValidator() {
	}

	public static List<String> checkValidInformation(List<String> processInformation) {
		if (hasThreeInformation(processInformation) && isValidProcess(processInformation) && isValidLevel(
			processInformation) && isValidMission(processInformation)) {
			return processInformation;
		}
		throw new IllegalArgumentException();
	}

	private static boolean hasThreeInformation(List<String> processInformation) {
		if (processInformation.size() != 3) {
			throw new IllegalArgumentException("[ERROR] 입력한 정보가 3개(과정, 레벨, 미션)가 아니다.");
		}
		return true;
	}

	private static boolean isValidProcess(List<String> processInformation) {
		if (ProcessValidator.isValidProcess(processInformation.get(0))) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidLevel(List<String> processInformation) {
		if (LevelValidator.isValidLevel(processInformation.get(1))) {
			return true;
		}
		throw new IllegalArgumentException();
	}

	private static boolean isValidMission(List<String> processInformation) {
		if (MissionValidator.isValidMission(processInformation.get(1), processInformation.get(2))) {
			return true;
		}
		throw new IllegalArgumentException();
	}
}
