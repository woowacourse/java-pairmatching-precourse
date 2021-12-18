package pairmatching.controller;

import pairmatching.utils.Constant;
import pairmatching.utils.ExceptionMessage;
import pairmatching.validator.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class InputService {
	private final InputValidator validator= new InputValidator();
	
	public String readFunction() {
		while(true) {
			try {
				OutputView.select_function();
				String input= InputView.select_fuction();
				validator.validate_function(input);
				return input;
			}catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	public String readCourse() {
		while(true) {
			try {
				OutputView.select_course();
				String input = InputView.select_course();
				validator.validate_inputSize(input);
				return input; 
			}catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public String readAnswer() {
		while(true) {
			String answer= InputView.askAnswer();
			if(answer.equals(Constant.ANSWER_YES)||answer.equals(Constant.ANSWER_NO)) {
				return answer;
			}
			System.out.println(ExceptionMessage.INPUT_ANSWER);
		}
	}
}
