package pairmatching.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import pairmatching.domain.PairProgrammings;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairProgrammingController {

    private String targetCourse;
    private String targetLevel;
    private String targetMission;

//    private List<String> backEndCrew = Arrays.asList("백호", "태웅", "치수", "태섭", "대만", "준호", "대협", "덕규", "태산", "경태", "수겸", "현준", "준섭", "한나", "소연", "호열", "대남", "용팔", "구식", "달재");
    private List<String> backEndCrew = Arrays
        .asList("백호", "태웅", "치수", "태섭", "대만", "준호");
    private List<String> frontEndCrew = Arrays
        .asList("보노", "시저", "쉐리", "신디", "다비", "덴버", "이브", "제시", "라라", "린다", "리사", "니콜", "로드",
            "윌터", "제키");
    private List<String> shuffledCrew;

    private PairProgrammings pairProgrammings = new PairProgrammings();

    public void run() {

        while (true) {
            String mainFunction = InputView.mainFunction();
            if (mainFunction.equals("1")) {
                enrollPair();
            }
            if (mainFunction.equals("2")) {
                viewPairInfo();
            }
            if (mainFunction.equals("3")) {
                pairProgrammings = new PairProgrammings();
            }
            if (mainFunction.equals("Q")) {
                break;
            }
        }
    }

    private void viewPairInfo() {
        requirePairProgrammingInfos();
        Map<String, Set<String>> pairInfo = null;
        try {
            pairInfo = pairProgrammings
                .getPairInfo(targetCourse, targetLevel, targetMission);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        if (!Objects.isNull(pairInfo)) {
            OutputView.printPairInfo(pairInfo, shuffledCrew);
        }
    }

    private void enrollPair() {
        requirePairProgrammingInfos();
        enrollNewProgram();
        OutputView.printPairInfo(pairProgrammings.getPairInfo(targetCourse, targetLevel, targetMission), shuffledCrew);
    }

    private void enrollNewProgram() {
        while (true) {
            try {
                pairProgrammings
                    .enrollNewProgram(targetCourse, targetLevel, targetMission, shuffledCrew);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
            break;
        }
    }

    private void requirePairProgrammingInfos() {
        String detailedFunction = InputView.detailedFunction();
        String[] detailedFunctions = detailedFunction.split(", ");
        this.targetCourse = detailedFunctions[0];
        this.targetLevel = detailedFunctions[1];
        this.targetMission = detailedFunctions[2];

        if (targetCourse.equals("프론트엔드")) {
            shuffledCrew = Randoms.shuffle(backEndCrew);
        }

        if (targetCourse.equals("백엔드")) {
            shuffledCrew = Randoms.shuffle(frontEndCrew);
        }
    }
}
