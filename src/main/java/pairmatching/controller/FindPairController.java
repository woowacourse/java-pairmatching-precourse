package pairmatching.controller;

import pairmatching.outputview.OutputView;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.vo.PairMatchingInfo;

import java.util.Map;

public class FindPairController implements Controller {
    private final OutputView outputView;
    private final PairMatchingRepository pairMatchingRepository;

    public FindPairController(OutputView outputView, PairMatchingRepository pairMatchingRepository) {
        this.outputView = outputView;
        this.pairMatchingRepository = pairMatchingRepository;
    }

    @Override
    public void process(Map<String, Object> model) {
        PairMatchingInfo pairMatchingInfo = (PairMatchingInfo) model.get("pairMatchingInfo");
        model.put("matchedPairNames", pairMatchingRepository.findAllNamesByPairMatchingInfo(pairMatchingInfo));
        outputView.print(model);
    }
}
