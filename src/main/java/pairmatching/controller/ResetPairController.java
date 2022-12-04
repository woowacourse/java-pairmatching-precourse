package pairmatching.controller;

import pairmatching.outputview.OutputView;
import pairmatching.repository.PairMatchingRepository;

import java.util.Map;

public class ResetPairController extends AbstractController {
    private final PairMatchingRepository pairMatchingRepository;
    private final OutputView outputView;

    public ResetPairController(PairMatchingRepository pairMatchingRepository, OutputView outputView) {
        this.pairMatchingRepository = pairMatchingRepository;
        this.outputView = outputView;
    }

    @Override
    public void doProcess(Map<String, Object> model) {
        pairMatchingRepository.resetAll();
        outputView.print(model);
    }
}
