package pairmatching.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InputValidator {
	private static final List<String> course = Arrays.asList("백엔드", "프론트엔드");
	private static final List<List<String>> level = new ArrayList<>();
	public static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String NOT_EXIST = "존재하지 않는 정보입니다.";
	private static final String NOT_EXIST_MENU = "존재하지 않는 메뉴입니다.";

	public InputValidator(){
		level.add(Arrays.asList("자동차경주","로또","숫자야구게임"));
		level.add(Arrays.asList("장바구니","결제","지하철노선도"));
		level.add(Arrays.asList(""));
		level.add(Arrays.asList("성능개선","배포"));
		level.add(Arrays.asList(""));
	}

	public boolean isValidInfo(String[] info) {
		try {
			validateExistInfo(info);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public boolean isValidNumber(String menu) {
		try {
			validateMenuInput(menu);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	private void validateExistInfo(String[] info) {
		if(!course.contains(info[0])){
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_EXIST);
		}
		int levelNumber=Integer.parseInt(info[1]
			.replace("레벨","").replace(" ",""));
		if(!level.get(levelNumber).contains(info[2])){
			throw new IllegalArgumentException(ERROR_MESSAGE + NOT_EXIST);
		}
	}

	private void validateMenuInput(String menu){
		if(!(menu.equals("Q")||menu.equals("1")||menu.equals("2")||menu.equals(3))){
			throw new IllegalArgumentException(InputValidator.ERROR_MESSAGE + NOT_EXIST_MENU);
		}
	}
}
