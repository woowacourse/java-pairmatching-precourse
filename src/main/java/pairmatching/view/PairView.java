package pairmatching.view;

public class PairView {
	private static final String GUIDE_MESSAGE = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################\n";

	private static final String INPUT_GUIDE_MESSAGE = "\n과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";


	public static void printGuideMessage() {
		System.out.println(GUIDE_MESSAGE);
	}

	public static void printInputGuideMessage() {
		System.out.println(INPUT_GUIDE_MESSAGE);
	}
}
