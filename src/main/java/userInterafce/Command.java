package userInterafce;

import camp.nextstep.edu.missionutils.Console;
import utils.WrongCommand;

public class Command {
	public void runMainInterface() {
		printMain();
		String input;

		do {
			input = Console.readLine();
			useKey(input);
		} while (new WrongCommand().check(input));
	}

	public void printMain() {
		System.out.println(
			"기능을 선택하세요.\n"
				+ "1. 페어 매칭\n"
				+ "2. 페어 조회\n"
				+ "3. 페어 초기화\n"
				+ "Q. 종료");
	}

	public void useKey(String input) {
		if (input.equals("1")) {
			new PairMatch().run();
		} else if (input.equals("2")) {
			// 매칭 조회
		} else if (input.equals("3")) {
			// 매칭 초기화
		} else if (input.equals("Q")) {
			// 종료
		}
	}
}
