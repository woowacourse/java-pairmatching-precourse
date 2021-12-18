package pairmatching.view;

import java.util.Arrays;
import java.util.List;

public class Message {
	public static final String FUNCTION_SELECT_LABEL = "기능을 선택하세요.";
	public static final String FUNCTION_SELECT_PAIR_MATCHING = "1. 페어 매칭";
	public static final String FUNCTION_SELECT_PAIR_FIND = "2. 페어 조회";
	public static final String FUNCTION_SELECT_PAIR_RESET = "3. 페어 초기화";
	public static final String FUNCTION_SELECT_QUIT = "Q. 종료";
	public static final List<String> FUNCTION_SELECT = Arrays.asList(
			FUNCTION_SELECT_LABEL,
			FUNCTION_SELECT_PAIR_MATCHING,
			FUNCTION_SELECT_PAIR_FIND,
			FUNCTION_SELECT_PAIR_RESET,
			FUNCTION_SELECT_QUIT
	);

	public static final String PAIR_MATCHING = "\n#############################################\n"
			+ "과정: 백엔드 | 프론트엔드\n"
			+ "미션:\n"
			+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
			+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
			+ "  - 레벨3: \n"
			+ "  - 레벨4: 성능개선 | 배포\n"
			+ "  - 레벨5: \n"
			+ "############################################";
	public static final String SELECT_PAIR_MATCHING_LIST= "과정, 레벨, 미션을 선택하세요.\n"
			+ "ex) 백엔드, 레벨1, 자동차경주";

	public static final String ASK_REMATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
			+ "네 | 아니오";

	public static final String RESET_SUCCESS = "초기화 되었습니다.";
}
