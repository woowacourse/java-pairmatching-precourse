package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.OutputView;

public class InputView {
    private static final String SELECT_MENU_MESSAGE = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";
    private static final String INPUT_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";
    private static final String REMATCHING_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    public static final String YES = "네";
    public static final String NO = "아니오";


    public static String selectMenu() {
        System.out.println(SELECT_MENU_MESSAGE);
        return Console.readLine();
    }

    public static String inputCourseLevelMission() {
        System.out.println(INPUT_COURSE_LEVEL_MISSION_MESSAGE);
        return Console.readLine();
    }

    public static String askMatchingAgain() {
        System.out.println(REMATCHING_MESSAGE);
        System.out.println(YES + OutputView.VERTICAL_VAR + NO);
        return Console.readLine();
    }
}