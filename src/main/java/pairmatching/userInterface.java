package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class userInterface {

	public void runMainInterface() {
		printMain();
		String input;

		do {
			input = Console.readLine();
			useKey(input);
		} while (validator(input));
	}

	public void printMain() {
		System.out.println(
			"기능을 선택하세요.\n"
			+ "1. 페어 매칭\n"
			+ "2. 페어 조회\n"
			+ "3. 페어 초기화\n"
			+ "Q. 종료");
	}

	private boolean validator(String input) {
		try {
			// 에러 체크.
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return true;
		}
		return false;
	}

	public void useKey(String input) {
		if (input.equals("1")) {
			// 매칭 실행
		} else if (input.equals("2")) {
			// 매칭 조회
		} else if (input.equals("3")) {
			// 매칭 초기화
		} else if (input.equals("Q")) {
			// 종료
		}
		throw new IllegalArgumentException();
	}
}
