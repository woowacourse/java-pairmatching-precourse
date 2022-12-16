package pairmatching.controller;

import pairmatching.domain.MissionPair;
import pairmatching.domain.match.MatchData;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import static pairmatching.util.Constants.*;
import static pairmatching.util.Constants.FUNC_QUIT;

public class PairController extends Controller{

    private boolean gameRun = true;
    private final PairService pairService = new PairService();
    public PairController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
    }

    @Override
    public void run() {

        while(gameRun) {
            String function = readFunction();
            doFunction(function);
        }
    }

    private String readFunction() {
        String func = repeat(inputView::readFunction);
        return func;
    }
    public void doFunction(String func) {
        if (func.equals(FUNC_MATCH)) {
            MatchData matchData = readMatchData();
            MissionPair missionPair = pairService.doPairMatchingFunction(matchData);
            outputView.printMissionPairs(missionPair);
        } else if (func.equals(FUNC_SHOW)) {

        } else if (func.equals(FUNC_RESET)) {

        } else if (func.equals(FUNC_QUIT)) {
            gameRun = false;
        }
    }

    private MatchData readMatchData() {
        MatchData matchData = repeat(inputView::readMatchData);
        return matchData;
    }
}
