package pairmatching.controller;

import pairmatching.service.PairService;

public class PairController {
    private final PairService pairService;

    public PairController(PairService pairService) {
        this.pairService = pairService;
    }

    public void createPairs(String[] pairInfo) {
        pairService.createPairs(pairInfo);
    }
}
