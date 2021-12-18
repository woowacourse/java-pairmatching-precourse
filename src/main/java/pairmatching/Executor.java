package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.missionName.MissionName;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Executor {

    public void execute() throws FileNotFoundException {
        MissionManager missionManager = new MissionManager();
        missionManager.init();

        while (true) {
            String selection = getFunctionSelection();
            executeFunction(missionManager, selection);

            if ("Q".equals(selection)) {
                return;
            }
        }
    }

    public static final String FUNCTION_SELECTION_MESSAGE = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료\n";

    public static final String PAIR_MATCHING_MESSAGE = "#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################\n";

    public Executor() {};

    public String getFunctionSelection() {
        System.out.println(FUNCTION_SELECTION_MESSAGE);
        String selectionInput = Console.readLine().trim();
        Validator.validateSelection(selectionInput);

        return selectionInput;
    }

    public void executeFunction(MissionManager missionManager, String selection) throws FileNotFoundException {
        if ("1".equals(selection)) {
            System.out.println("과정, 레벨, 미션을 선택하세요.\n" + "ex) 백엔드, 레벨1, 자동차경주");
            List<String> inputList = Arrays.asList(Console.readLine().trim().split(","));
            Level level = Level.of(inputList.get(1).trim());
            Course course = Course.of(inputList.get(0).trim());
            MissionName missionName = MissionName.of(inputList.get(2).trim());

            if (missionManager.isMissionExists(level, course, missionName)) {
                System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" + "네 | 아니오");
                String answer = Console.readLine().trim();
                if (!Validator.validateYesOrNo(answer)) {
                    return;
                }

                missionManager.generatePair(course, level, missionName);
                printPairList(missionManager, course, level, missionName);
            }
        }

    }

    public void printPairList (MissionManager missionManager, Course course, Level level, MissionName missionName) {
        List<Pair> pairList = missionManager.getPairList(course, level, missionName);

        System.out.println("페어 매칭 결과입니다.");
        String pairInfo = "";
        for (Pair pair : pairList) {
            System.out.println(String.join(" : ", pair.getPairMemberNameList()));
        }
    }
}
