package pairmatching.view;

import pairmatching.domain.CrewList;

import java.util.List;

import static pairmatching.constant.OutputViewMessage.GUIDE_PROCESS_MESSAGE;
import static pairmatching.constant.SystemMessage.*;

public class OutputView {
    public static void printProcess() {
        System.out.println(GUIDE_PROCESS_MESSAGE);
    }

    public static void printMatchingResult(CrewList crewList) {
        System.out.println(crewList);
    }
}
