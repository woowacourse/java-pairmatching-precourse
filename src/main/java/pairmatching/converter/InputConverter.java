package pairmatching.converter;

import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairInfo;
import pairmatching.domain.PairInfoRepository;
import pairmatching.validator.FunctionValidator;

public class InputConverter {

	private static FunctionValidator functionValidator = new FunctionValidator();
	private static PairInfoRepository pairInfoRepository = new PairInfoRepository();

	public static Function convertFunction(String input) {
		functionValidator.validateFunctionNumber(input);
		return Function.getByNumber(input);
	}

	public static PairInfo convertPairInfo(String input) {
		String[] inputArray = input.split(", ");

		Course course = Course.getByName(inputArray[0]);
		Level level = Level.getByName(inputArray[1]);
		Mission mission = Mission.getByName(inputArray[2]);

		return new PairInfo(course, mission);
	}
}
