package pairmatching.view;

import pairmatching.domain.matching.MatchingCondition;
import pairmatching.domain.matching.MatchingResults;
import pairmatching.domain.pair.Pairs;

public class OutputView {

    public static final String SEPARATOR_LINE = "#############################################";
    public static final String COURSES = "과정: 백엔드 | 프론트엔드";
    public static final String MISSIONS = "미션:";
    private static final String LEVEL_ONE_MISSION = "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임";
    private static final String LEVEL_TWO_MISSION = "  - 레벨2: 장바구니 | 결제 | 지하철노선도";
    private static final String LEVEL_THREE_MISSION = "  - 레벨3: ";
    private static final String LEVEL_FOUR_MISSION = "  - 레벨4: 성능개선 | 배포";
    private static final String LEVEL_FIVE_MISSION = "  - 레벨5: ";
    public static final String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";
    public static final String NO_PAIR_MESSAGE = "[ERROR] 페어가 매칭되지 않았습니다";

    public static void showCoursesAndMissions() {
        System.out.println(SEPARATOR_LINE);
        System.out.println(COURSES);
        System.out.println(MISSIONS);
        System.out.println(LEVEL_ONE_MISSION);
        System.out.println(LEVEL_TWO_MISSION);
        System.out.println(LEVEL_THREE_MISSION);
        System.out.println(LEVEL_FOUR_MISSION);
        System.out.println(LEVEL_FIVE_MISSION);
        System.out.println(SEPARATOR_LINE);
    }

    public static void showPairs(Pairs pairs) {
        System.out.println(PAIR_MATCHING_RESULT);
        System.out.println(pairs.toString());
    }

    public static void showExistPairs(MatchingResults matchingResults, MatchingCondition matchingCondition) {
        if (matchingResults.cotains(matchingCondition)) {
            Pairs pairs = matchingResults.getPairs(matchingCondition);
            System.out.println(pairs);
            return;
        }
        System.out.println(NO_PAIR_MESSAGE);
    }
}
