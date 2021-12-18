package pairmatching.view;

public class FunctionMessage {

	public static final String FUNCTION_SELECT = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";

	public static void printManual() {
		System.out.println(FUNCTION_SELECT);
	}
}
