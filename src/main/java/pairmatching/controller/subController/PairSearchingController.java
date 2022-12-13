package pairmatching.controller.subController;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import pairmatching.domain.PairMatchingResult;
import pairmatching.domain.option.PairingOption;
import pairmatching.domain.repository.PairMatchingResults;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairSearchingController implements Controllable {


    private final InputView inputView;
    private final OutputView outputView;
    private final Map<PairSearchingStatus, Supplier<PairSearchingStatus>> pairSearchingGuide;
    private PairingOption pairingOption;

    private enum PairSearchingStatus {
        SELECT_PAIRING_OPTION,
        NO_MATCHING_HISTORY,
        ATTEMPT_PAIR_SEARCHING,
        EXIT_PAIR_SEARCHING;

        boolean continuePairSearching() {
            return this != EXIT_PAIR_SEARCHING;
        }
    }

    public PairSearchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairSearchingGuide = new EnumMap<>(PairSearchingStatus.class);
        initializePairSearchingGuide();
    }

    private void initializePairSearchingGuide() {
        pairSearchingGuide.put(PairSearchingStatus.SELECT_PAIRING_OPTION, this::selectPairingOption);
        pairSearchingGuide.put(PairSearchingStatus.NO_MATCHING_HISTORY, this::handleNoMatchingHistory);
        pairSearchingGuide.put(PairSearchingStatus.ATTEMPT_PAIR_SEARCHING, this::attemptPairSearching);
    }


    @Override
    public void process() {
        PairSearchingStatus pairSearchingStatus = PairSearchingStatus.SELECT_PAIRING_OPTION;
        while (pairSearchingStatus.continuePairSearching()) {
            pairSearchingStatus = pairSearchingGuide.get(pairSearchingStatus).get();
        }
    }

    private PairSearchingStatus selectPairingOption() {
        pairingOption = inputView.readPairingOption();
        if (!PairMatchingResults.hasPreviousMatching(pairingOption)) {
            return PairSearchingStatus.NO_MATCHING_HISTORY;
        }
        return PairSearchingStatus.ATTEMPT_PAIR_SEARCHING;
    }

    private PairSearchingStatus handleNoMatchingHistory() {
        outputView.printNoMatchingHistory();
        return PairSearchingStatus.EXIT_PAIR_SEARCHING;
    }

    private PairSearchingStatus attemptPairSearching() {
        PairMatchingResult result = PairMatchingResults.searchByPairingOption(pairingOption);
        outputView.printPairMatching(result.getPairMatchingResult());
        return PairSearchingStatus.EXIT_PAIR_SEARCHING;
    }


}
