package pairmatching.utils;

public class Constant {
	public static final String PATH_BACKEND = "C:\\Users\\Yuharim\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";
	public static final String PATH_FRONTEND ="C:\\Users\\Yuharim\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md";
	
	public static final int INPUT_LENGTH = 3;
	public static final int POSITION_COURSE = 1;
	public static final int POSITION_LEVEL = 2;
	public static final int POSITION_MISSION = 3;
	
	public static final String COURSE_MATCHING_NUMBER = "1";
	public static final String COURSE_INQUERY_NUMBER = "2";
	public static final String COURSE_INTI_NUMBER = "3";
	
	public static final String COURSE_MATCHING = "페어 매칭";
	public static final String COURSE_INQUERY = "페어 조회";
	public static final String COURSE_INIT = "페어 초기화";
	public static final String COURSE_QUIT = "종료";
	
	public static final String DELIMITER_SELECT = ",";
	public static final String DELIMITER_RESULT = " : ";
	
	public static final String ANSWER_YES = "네";
	public static final String ANSWER_NO = "아니오";
	
	//안내 메시지
	public static final String SELECT_FUNCTION = "기능을 선택하세요.\n"
							+ "1. 페어 매칭\n"
							+ "2. 페어 조회\n"
							+ "3. 페어 초기화\n"
							+ "Q. 종료";
	public static final String INFORMATION_COURSE = "#############################################\n" + 
									"과정: 백엔드 | 프론트엔드\n" + 
									"미션:\n" + 
									"  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" + 
									"  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" + 
									"  - 레벨3: \n" + 
									"  - 레벨4: 성능개선 | 배포\n" + 
									"  - 레벨5: \n" + 
									"############################################";
	public static final String SELECT_COURSE = "과정, 레벨, 미션을 선택하세요.\n"
									+ "ex) 백엔드, 레벨1, 자동차경주";
	public static final String RESULT = "페어 매칭 결과입니다.";
	
	//선택에 따른 메시지
	public static final String HISTORY_NULL = "매칭 이력이 없습니다.";
	public static final String EXIST_HISTORY = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
											+ "네 | 아니오";
	public static final String COMPLETE_INIT = "초기화 되었습니다."; 
}
