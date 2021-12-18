package pairmatching.controller;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.Course;
import pairmatching.domain.Courses;
import pairmatching.view.InputView;

public class PairProgrammingController {
    private List<String> backEndCrew;
    private List<String> frontEndCrew;
    private Courses courses = new Courses();

    public PairProgrammingController() {
        backEndCrew = Arrays
            .asList("백호", "태웅", "치수", "태섭", "대만", "준호", "대협", "덕규", "태산", "경태", "수겸", "현준", "준섭",
                "한나", "소연", "호열", "대남", "용팔", "구식", "달재");
        frontEndCrew = Arrays
            .asList("보노", "시저", "쉐리", "신디", "다비", "덴버", "이브", "제시", "라라", "린다", "리사", "니콜", "로드",
                "윌터", "제키");
    }

    public void run() {
        String mainFunction = InputView.mainFunction();

        if (mainFunction.equals("1")) {

            String detailedFunction = InputView.detailedFunction();
            detailedFunction.split(", ");
        }
    }
}
