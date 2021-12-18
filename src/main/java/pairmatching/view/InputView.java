package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static pairmatching.constant.InputViewMessage.ASK_PROCESS_LEVEL_MISSION_MESSAGE;
import static pairmatching.constant.InputViewMessage.ASK_USER_CHOICE_MESSAGE;

public class InputView {
    public static String getUserChoice() {
        System.out.println(ASK_USER_CHOICE_MESSAGE);
        return readLine();
    }

    public static String getProcessLevelMission() {
        System.out.println(ASK_PROCESS_LEVEL_MISSION_MESSAGE);
        return readLine();
    }
}
