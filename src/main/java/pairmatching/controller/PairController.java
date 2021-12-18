package pairmatching.controller;

import pairmatching.domain.pair.Pair;
import pairmatching.service.PairService;

public class PairController {
    private final PairService pairService;

    public PairController(PairService pairService) {
        this.pairService = pairService;
    }

    public Pair createPairs(String[] pairInfo) {
        return pairService.createPairs(pairInfo);
    }
}
