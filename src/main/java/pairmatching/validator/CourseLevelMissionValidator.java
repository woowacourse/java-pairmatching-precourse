package pairmatching.validator;

public class CourseLevelMissionValidator extends Validator {
	private static final String ERROR_INVALID_INPUT = "[ERROR] 잘못된 입력입니다.";

	@Override
	public String validate(String input) {
		isCourseLevelMissionSplitValid(input);
		return input;
	}

	private static void isCourseLevelMissionSplitValid(String input) {
		String[] courseLevelMission = input.split(", ");
		if (courseLevelMission.length != 3) {
			throw new IllegalArgumentException(ERROR_INVALID_INPUT);
		}
	}

	//TODO 각각의 과정, 레벨, 미션이 존재하는가에 대한 예외처리 필요
}
