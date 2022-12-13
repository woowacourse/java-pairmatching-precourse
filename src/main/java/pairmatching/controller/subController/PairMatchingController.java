package pairmatching.controller.subController;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.PairMatchingResult;
import pairmatching.domain.option.PairingOption;
import pairmatching.domain.repository.PairMatchingResults;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController implements Controllable {

    private InputView inputView;
    private OutputView outputView;


    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {

        int attempts = 1;

        PairingOption pairingOption = inputView.readPairingOption();
        PairMatchingResult result = new PairMatchingResult(pairingOption);

        if (PairMatchingResults.hasPreviousMatching(pairingOption)) {
            if (inputView.readRematchOption().isNo()) {
                // 처리
            }
        }

        List<List<Crew>> pairMatchingResult = result.getPairMatchingResult();
        System.out.println(pairMatchingResult);
        if (PairMatchingResults.hasDuplicatedPairsInSameLevel(result)) {
            System.out.println("중복되는 크루가 있음!");
        }

    }
}
