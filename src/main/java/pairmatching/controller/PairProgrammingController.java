package pairmatching.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import pairmatching.domain.PairProgrammings;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairProgrammingController {
    private List<String> backEndCrew = Arrays
        .asList("백호", "태웅", "치수", "태섭", "대만", "준호", "대협", "덕규", "태산", "경태", "수겸", "현준", "준섭",
            "한나", "소연", "호열", "대남", "용팔", "구식", "달재");
    private List<String> frontEndCrew = Arrays
        .asList("보노", "시저", "쉐리", "신디", "다비", "덴버", "이브", "제시", "라라", "린다", "리사", "니콜", "로드",
            "윌터", "제키");
    private List<String> shuffledCrew;

    private PairProgrammings pairProgrammings = new PairProgrammings();

    public void run() {

        while (true) {
            String mainFunction = InputView.mainFunction();
            if (mainFunction.equals("1")) {
                String detailedFunction = InputView.detailedFunction();
                String[] detailedFunctions = detailedFunction.split(", ");
                String targetCourse = detailedFunctions[0];
                String targetLevel = detailedFunctions[1];
                String targetMission = detailedFunctions[2];

                if (targetCourse.equals("백엔드")) {
                    shuffledCrew = Randoms.shuffle(backEndCrew);
                }

                pairProgrammings.enrollNewProgram(targetCourse, targetLevel, targetMission, shuffledCrew);
//                Map<String, Set<String>> pairInfo = pairProgrammings.getPairInfo(detailedFunction);

                OutputView.printPairInfo(pairProgrammings.getPairInfo(targetCourse, targetLevel, targetMission), shuffledCrew);
            }
            if (mainFunction.equals("Q")) {
                break;
            }

        }
    }
}
