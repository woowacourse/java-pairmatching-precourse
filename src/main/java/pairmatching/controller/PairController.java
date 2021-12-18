package pairmatching.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.service.Validator;
import pairmatching.view.ErrorMessage;
import pairmatching.view.PairView;

public class PairController {

	private static final int INPUT_SIZE = 3;
	private static final String SPLIT_REGEX = ", ";

	public static void startPairMatching(){

		PairView.printGuideMessage();

		List<String> input = getCourseLevelMission();
		for(String s:input){
			System.out.println("s = " + s);
		}
	}

	private static List<String> getCourseLevelMission() {
		PairView.printInputGuideMessage();
		try{
			String inputString = Console.readLine();
			return getValidStringList(inputString);
		} catch (IllegalArgumentException e){
			ErrorMessage.print(e.getMessage());
			return getCourseLevelMission();
		}

	}

	private static List<String> getValidStringList(String inputString) {
		Validator.validateFormat(inputString);
		List<String> inputList = Arrays.asList(inputString.split(SPLIT_REGEX));
		for(String s: inputList){
			System.out.println("s = " + s);
		}
		Validator.checkListSize(inputList, INPUT_SIZE);
		Validator.checkValidInput(inputList); // 과정, 레벨, 미션 확인
		return inputList;
	}
}
