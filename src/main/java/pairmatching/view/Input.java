package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Command;
import pairmatching.domain.MatchingInfo;

public class Input {


    private static final String REQUEST_FEATURE_MESSAGE = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";
    private static final String REQUEST_MISSION_INFO_MESSAGE = "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주";
    private static final String REQUEST_COMMAND_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
            + "네 | 아니오";

    public Command inputCommand() {
        System.out.println(REQUEST_FEATURE_MESSAGE);
        try {
            return Command.from(readTrimLine());
        } catch (IllegalArgumentException i) {
            System.out.println(i.getMessage());
            return inputCommand();
        }
    }

    public MatchingInfo inputMatchingInfo() {
        System.out.println(REQUEST_MISSION_INFO_MESSAGE);
        try {
            return MatchingInfo.createMatchingInfo(
                    readTrimLine().replaceAll("\\s", "").split(","));
        } catch (IllegalArgumentException i) {
            System.out.println(i.getMessage());
            return inputMatchingInfo();
        }
    }


    public String inputRetryMatch() {
        System.out.println(REQUEST_COMMAND_MESSAGE);
        return readTrimLine();
    }

    private static String readTrimLine() {
        return Console.readLine().trim();
    }
}
