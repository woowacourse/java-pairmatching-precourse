package pairmatching.controller;

import java.util.Arrays;
import java.util.List;

public class PairProgrammingController {
    private List<String> backEndCrew;
    private List<String> frontEndCrew;

    public PairProgrammingController() {
        backEndCrew = Arrays
            .asList("백호", "태웅", "치수", "태섭", "대만", "준호", "대협", "덕규", "태산", "경태", "수겸", "현준", "준섭",
                "한나", "소연", "호열", "대남", "용팔", "구식", "달재");
        frontEndCrew = Arrays
            .asList("보노", "시저", "쉐리", "신디", "다비", "덴버", "이브", "제시", "라라", "린다", "리사", "니콜", "로드",
                "윌터", "제키");
    }

    public void run() {
    }
}
