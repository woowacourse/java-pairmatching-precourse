package pairmatching.io;

import static camp.nextstep.edu.missionutils.Console.*;
import static pairmatching.domain.Course.*;
import static pairmatching.domain.Level.*;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.matching.MatchingFactory;
import pairmatching.domain.matching.MatchingType;
import pairmatching.exception.FunctionInputFormatException;
import pairmatching.exception.MatchingTypeInputException;

public class Input {
	private static final Pattern INPUT_FORMAT_CHOOSE_FUNCTION = Pattern.compile("[1-3|Q,q]");
	private String input;
	private String[] inputData;
	private boolean flag;
	private Matcher matcher;
	private Mission mission;

	public Input(Mission mission){
		this.mission = mission;
	}

	/*******************기능 타입 입력*******************************/

	public String inputChooseFunction() {
		printChooseFunction();

		while(!validateFunctionInput(input=readLine())){
			// validateFunctionInput
		}
		return input;
	}

	private boolean validateFunctionInput(String input){
		flag = true;
		matcher = INPUT_FORMAT_CHOOSE_FUNCTION.matcher(input);
		try{
			isChooseFunctionFormat(input);
		} catch (IllegalArgumentException e){
			flag = false;
		}
		return flag;
	}

	private void isChooseFunctionFormat(String input) {
		if(!INPUT_FORMAT_CHOOSE_FUNCTION.matcher(input).matches()){
			throw new FunctionInputFormatException();
		}
	}

	private void printChooseFunction() {
		System.out.println("기능을 선택하세요.");
		System.out.println("1. 페어 매칭");
		System.out.println("2. 페어 조회");
		System.out.println("3. 페어 초기화");
		System.out.println("Q. 종료");
	}

	/*******************기능 타입 입력값으로 그에 맞는 연산 수행*******************************/

	public void inputPairing(int opType, Set<MatchingType> matchingSet) {
		if (opType == 1) { // 페어 매칭
			pairMatchingProcess(matchingSet);
		} else if (opType == 2) { // 페어 조회
			pairSelectingProcess(matchingSet);
		} else if (opType == 3) { // 페어 초기
			matchingSet.clear();
		}
	}

	private void pairSelectingProcess(Set<MatchingType> matchingSet) {
		MatchingType matchingType = inputMatchingType();

		// 매칭 결과가 있을 경우
		if(matchingSet.contains(matchingType)){
			System.out.println(MatchingFactory.getMatching(matchingType));
			return;
		}
		System.out.println("매칭 결과가 없습니다.");
	}

	private void pairMatchingProcess(Set<MatchingType> matchingSet) {
		MatchingType matchingType = inputMatchingType();
		boolean flag = false;
		// 매칭 정보가 이미 있을 경우
		if (!matchingSet.add(matchingType)) {
			flag = true;
			System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"+
				"네 | 아니오");
			input =  readLine();
			if(input.equalsIgnoreCase("아니오")){
				return;
			}
		}

		// 없거나 "네"를 입력한 경우
		if((flag && input.equalsIgnoreCase("네"))
			|| !flag){
			if (inputData[0].equalsIgnoreCase(BACKEND.getName())) {
				MatchingFactory.insertMatchingList(matchingType, BACKEND);
			} else if (inputData[0].equalsIgnoreCase(FRONTEND.getName())) {
				MatchingFactory.insertMatchingList(matchingType, FRONTEND);
			}
			System.out.println(MatchingFactory.getMatching(matchingType));
		}
	}

	/*******************매칭 타입 입력*******************************/

	public MatchingType inputMatchingType() {
		// 프론트엔드, 레벨1, 자동차경주
		while(!validateMatchingFormat(input = readLine())){
			// validateMatchingFormat, validateMatchingType
		}
		inputData = input.split(", ");
		String courseName = inputData[0];
		String levelName = inputData[1];
		String missionName = inputData[2];
		return new MatchingType(Course.findByName(courseName), Level.findByName(levelName), missionName);
	}

	private boolean validateMatchingFormat(String types){
		flag = true;
		try{
			isMatchingTypeExisted(types);
		} catch (IllegalArgumentException e){
			flag = false;
		}
		return flag;
	}

	private void isMatchingTypeExisted(String types){
		String[] matchingType = types.split(", ");
		String course = matchingType[0];
		if(!getCourseList().stream().anyMatch(s -> s.equalsIgnoreCase(course))){
			throw new MatchingTypeInputException();
		}
		String level = matchingType[1];
		if(!getLevelNameList().stream().anyMatch(s -> s.equals(level))){
			throw new MatchingTypeInputException();
		}

		String missionName = matchingType[2];
		if(!mission.getMissionListByLevel(Level.findByName(level)).stream().anyMatch(s -> s.equalsIgnoreCase(missionName))){
			throw new MatchingTypeInputException();
		}
	}


}
