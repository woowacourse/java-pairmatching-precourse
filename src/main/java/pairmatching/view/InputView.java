package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CHOOSE_FUNCTION = "기능을 선택하세요.";
    private static final String ONE_PAIR_MATCHING = "1. 페어 매칭";
    private static final String TWO_PAIR_FIND = "2. 페어 조회";
    private static final String THREE_PAIR_RESET = "3. 페어 초기화";
    private static final String QUIT = "Q. 종료";

    private static final String CHOOSE_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.";
    private static final String EX_CHOOSE_COURSE_LEVEL_MISSION = "ex) 백엔드, 레벨1, 자동차경주";

    private static final String EXIST_MATCHING_INFO = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    private static final String YES_OR_NO = "네 | 아니오";

    public static String insertMainFunction() {
        System.out.println(CHOOSE_FUNCTION);
        System.out.println(ONE_PAIR_MATCHING);
        System.out.println(TWO_PAIR_FIND);
        System.out.println(THREE_PAIR_RESET);
        System.out.println(QUIT);

        return getInput();
    }

    public static String insertCourseLevelMission() {
        System.out.println(CHOOSE_COURSE_LEVEL_MISSION);
        System.out.println(EX_CHOOSE_COURSE_LEVEL_MISSION);

        return getInput();
    }

    public static String insertReMatching() {
        System.out.println(EXIST_MATCHING_INFO);
        System.out.println(YES_OR_NO);

        return getInput();
    }

    private static String getInput() {
        String input = Console.readLine();
        OutputView.printLineBreak();
        return input;
    }


}
