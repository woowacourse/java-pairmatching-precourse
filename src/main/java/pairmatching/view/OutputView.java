package pairmatching.view;

import java.util.List;

import static pairmatching.constant.OutputViewMessage.GUIDE_PROCESS_MESSAGE;
import static pairmatching.constant.SystemMessage.*;

public class OutputView {
    public static void printProcess() {
        System.out.println(GUIDE_PROCESS_MESSAGE);
    }

    public static void printMatchingResult(List<String> crewList) {
        if (crewList.size() % EVEN == 0) {
            for (int i = 0; i < crewList.size(); i = i + EVEN) {
                System.out.println(String.join(" : ", crewList.subList(i, i + EVEN)));
            }
        }
        if (crewList.size() % EVEN == 1) {
            for (int i = 0; i < crewList.size() - ODD_THREE; i = i + EVEN) {
                System.out.println(String.join(" : ", crewList.subList(i, i + EVEN)));
            }
            System.out.println(String.join(" : ", crewList.subList(crewList.size() - ODD_THREE, crewList.size())));
        }
    }
}
