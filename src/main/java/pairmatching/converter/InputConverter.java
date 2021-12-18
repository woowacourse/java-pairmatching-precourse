package pairmatching.converter;

import pairmatching.domain.Function;
import pairmatching.validator.FunctionValidator;

public class InputConverter {

	private static FunctionValidator functionValidator = new FunctionValidator();

	public static Function convertFunction(String input) {
		functionValidator.validateFunctionNumber(input);
		return Function.getByNumber(input);
	}
}
