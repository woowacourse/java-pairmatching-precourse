package pairmatching.controller;

import java.util.List;

import pairmatching.domain.Init;
import pairmatching.domain.Mission;

public class ResetController {
    private final Init init;

    public ResetController(Init init) {
        this.init = init;
    }

    public void reset() {
        List<Mission> missionList = init.getMissionInformation();
        missionList.stream().forEach(mission -> mission.reset());
    }
}
