package pairmatching.validator;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.utils.Constant;
import pairmatching.utils.ExceptionMessage;

public class InputValidator {
	
	public void validate_function(String input) {
		if(input.equals("Q")) return;
		try{
			if(input.matches("^[1-3]*$")) return;
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException(ExceptionMessage.INPUT_FUNCTION);
		}
	}
	
	public void validate_inputSize(String input) {
		if(input.split(Constant.DELIMITER_SELECT).length != Constant.INPUT_LENGTH)
			throw new IllegalArgumentException(ExceptionMessage.INPUT_LENGTH);;
	}
	
	public void validate_course(String input) {
		if(!Course.hasCourse(input))
			throw new IllegalArgumentException(ExceptionMessage.INPUT_COURSE);
	}
	
	public void validate_level(String input) {
		if(!Level.hasLevel(input)) {
			throw new IllegalArgumentException(ExceptionMessage.INPUT_LEVEL);
		}
	}
}
