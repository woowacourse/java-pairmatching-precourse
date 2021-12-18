package pairmatching.domain.validation;

public class Text {
    public static final String REGEX_MENU = "^[1-3Qq]?$";
    public static final String EMPTY_STRING = "";
    public static final String[][] MISSION_NAME = {{"자동차경주", "로또", "숫자야구게임"},
            {"장바구니", "결제", "지하철노선도"},
            {EMPTY_STRING},
            {"성능개선", "배포"},
            {EMPTY_STRING}};
    public static final String REGEX_INFORMATION = "^[ㄱ-ㅎ가-힣]{3,5}+, 레벨[1-5]?, [ㄱ-ㅎ가-힣]+$";
    public static final String SEPARATOR = ", ";
    public static final String BACKEND = "백엔드";
    public static final String FRONTEND = "프론트엔드";
    public static final String YES = "네";
    public static final String NO = "아니오";
}
