package pairmatching.util;

public class Message {

    private Message() {
    }

    public static final String MENU_GUIDE = "기능을 선택하세요.\n"
        + "1. 페어 매칭\n"
        + "2. 페어 조회\n"
        + "3. 페어 초기화\n"
        + "Q. 종료";
    public static final String ERROR = "[ERROR]";
    public static final String MENU_ERROR = "기능 선택 종류에 있는 것만 선택 가능합니다.";
    public static final String LEVEL_ERROR = "레벨 종류에 있는 것만 선택 가능합니다.";
    public static final String COURSE_ERROR = "코스 종류에 있는 것만 선택 가능합니다.";
}
