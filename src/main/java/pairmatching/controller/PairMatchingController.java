package pairmatching.controller;

import pairmatching.service.CrewService;

public class PairMatchingController {
    private final CrewService crewService;

    public PairMatchingController() {
        this.crewService = new CrewService();
    }

    public void run() {
        /* TODO:
            1. 프로그램 기능 선택
            2. 선택한 기능 수행
         */
        setCrewList();
    }

    private void setCrewList() {
        crewService.initCrewsByReader();
    }
}
