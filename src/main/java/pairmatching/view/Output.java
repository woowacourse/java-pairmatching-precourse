package pairmatching.view;

import pairmatching.domain.pair.Pairs;

public class Output {

    private static final String MISSIN_INFO_MESSAGE = "\n#############################################\n"
            + "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: \n"
            + "############################################";
    public static final String INIT_MESSAGE = "초기화 되었습니다.";

    public static void printPairs(Pairs pairs) {
        System.out.println(pairs.toString() + "\n");
    }

    public static void printMissionInfo() {
        System.out.println(MISSIN_INFO_MESSAGE);
    }

    public static void printInitMessage() {
        System.out.println(INIT_MESSAGE);
    }
}
