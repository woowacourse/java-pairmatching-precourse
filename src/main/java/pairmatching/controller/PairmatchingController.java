package pairmatching.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class PairmatchingController {
    public static List<String> pairmatchingStart(List<String> crewFrontendNames) {
        List<String> shuffledCrew = Randoms.shuffle(crewFrontendNames);
        return shuffledCrew;
    }
}
