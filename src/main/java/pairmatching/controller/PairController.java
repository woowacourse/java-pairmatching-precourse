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
        readFunction();
        readMatchData();
    }

    private void readFunction() {
        String func = repeat(inputView::readFunction);
    }

    private void readMatchData() {
        MatchData matchData = repeat(inputView::readMatchData);
    }
}
