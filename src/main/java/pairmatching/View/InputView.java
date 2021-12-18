package pairmatching.View;

import java.util.Scanner;

public class InputView {
	private static final String FUNCTION_NUMBER_GUIDE_MESSEAGE = "기능을 선택하세요.\n" + "1. 페어 매칭\n" + "2. 페어 조회\n" + "3. 페어 초기화\n" + "Q. 종료";

	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public int scanFunctionNumber() {
		System.out.println(FUNCTION_NUMBER_GUIDE_MESSEAGE);
		return Integer.parseInt(scanner.nextLine());
	}
}
