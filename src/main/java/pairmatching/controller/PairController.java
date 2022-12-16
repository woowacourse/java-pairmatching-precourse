package pairmatching.controller;

import pairmatching.domain.MatchData;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController extends Controller{

    private final PairService pairService = new PairService();
    public PairController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
    }

    @Override
    public void run() {
        String function = readFunction();
        MatchData matchData = readMatchData();
        pairService.doFunction(function, matchData);
    }

    private String readFunction() {
        String func = repeat(inputView::readFunction);
        return func;
    }

    private MatchData readMatchData() {
        MatchData matchData = repeat(inputView::readMatchData);
        return matchData;
    }
}
