package view;

public class CurriculumBoard {
    private static final String LINE = "#############################################";
    private static final String COURSE = "과정: 백엔드 | 프론트엔드";
    private static final String MISSION = "미션:";
    private static final String LEVEL1_MISSION = "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임";
    private static final String LEVEL2_MISSION = "  - 레벨2: 장바구니 | 결제 | 지하철노선도";
    private static final String LEVEL3_MISSION = "  - 레벨3: ";
    private static final String LEVEL4_MISSION = "  - 레벨4: 성능개선 | 배포";
    private static final String LEVEL5_MISSION = "  - 레벨5: ";
    
    public static void showCurriculumBoard() {
        System.out.println(LINE);
        System.out.println(COURSE);
        System.out.println(MISSION);
        System.out.println(LEVEL1_MISSION);
        System.out.println(LEVEL2_MISSION);
        System.out.println(LEVEL3_MISSION);
        System.out.println(LEVEL4_MISSION);
        System.out.println(LEVEL5_MISSION);
        System.out.println(LINE);
    }
}
