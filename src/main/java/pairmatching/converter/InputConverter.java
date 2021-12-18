package pairmatching.converter;

import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairInfo;
import pairmatching.validator.FunctionValidator;
import pairmatching.validator.PairValidator;
import pairmatching.validator.YesOrNoValidator;

public class InputConverter {

	private static FunctionValidator functionValidator = new FunctionValidator();
	private static PairValidator pairValidator = new PairValidator();
	private static YesOrNoValidator yesOrNoValidator = new YesOrNoValidator();

	public static Function convertFunction(String input) {
		functionValidator.validateFunctionNumber(input);
		return Function.getByNumber(input);
	}

	public static PairInfo convertPairInfo(String input) {
		pairValidator.validateLength(input);

		String[] inputArray = input.split(", ");

		Course course = Course.getByName(inputArray[0]);
		pairValidator.validateCourse(course);

		Level level = Level.getByName(inputArray[1]);
		pairValidator.validateLevel(level);

		Mission mission = Mission.getByName(inputArray[2]);
		pairValidator.validateMission(mission);

		return new PairInfo(course, mission);
	}

	public static boolean convertYesOrNo(String input) {
		return yesOrNoValidator.validateAnswer(input);
	}
}
