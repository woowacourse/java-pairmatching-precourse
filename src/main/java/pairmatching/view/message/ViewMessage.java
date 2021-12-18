package pairmatching.view.message;

import pairmatching.util.Symbol;

public enum ViewMessage {
    INPUT_SELECT_FUNCTION("기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료"),
    INPUT_SELECT_MATCHING_INFO("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주"),
    INPUT_RE_MATCHING("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오"),

    OUTPUT_HASH_LINE("#############################################"),
    OUTPUT_COURSE("과정" + Symbol.COLON + Symbol.SPACE),
    OUTPUT_MISSION("미션" + Symbol.COLON),
    OUTPUT_MATCHING_RESULT("페어 매칭 결과입니다."),
    OUTPUT_RESET("초기화 되었습니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
