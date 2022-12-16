package pairmatching.controller;

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
        executeFunction();
    }

    private void executeFunction() {
        String func = repeat(inputView::readFunction);
        pairService.executeFunction(func);
    }
}
