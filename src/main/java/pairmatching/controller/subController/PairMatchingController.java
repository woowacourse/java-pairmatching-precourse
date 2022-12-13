package pairmatching.controller.subController;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import pairmatching.domain.PairMatchingResult;
import pairmatching.domain.option.PairingOption;
import pairmatching.domain.repository.PairMatchingResults;
import pairmatching.domain.status.PairMatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController implements Controllable {

    public static final int MAX_ATTEMPTS = 3;
    private InputView inputView;
    private OutputView outputView;

    private final Map<PairMatchingStatus, Supplier<PairMatchingStatus>> pairMatchingGuide;
    private PairingOption pairingOption;
    private int attempts = 1;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairMatchingGuide = new EnumMap<>(PairMatchingStatus.class);
        initializePairMatchingGuide();
    }

    private void initializePairMatchingGuide() {
        pairMatchingGuide.put(PairMatchingStatus.SELECT_PAIRING_OPTION, this::selectPairingOption);
        pairMatchingGuide.put(PairMatchingStatus.HANDLE_PREVIOUS_MATCHING, this::handlePreviousMatching);
        pairMatchingGuide.put(PairMatchingStatus.ATTEMPT_MATCHING, this::attemptMatching);
        pairMatchingGuide.put(PairMatchingStatus.HANDLE_DUPLICATED_PAIRS, this::handleDuplicatedPairs);
    }

    @Override
    public void process() {
        PairMatchingStatus pairMatchingStatus = PairMatchingStatus.SELECT_PAIRING_OPTION;
        while (pairMatchingStatus.continuePairMatching()) {
            pairMatchingStatus = pairMatchingGuide.get(pairMatchingStatus).get();
        }
    }

    private PairMatchingStatus selectPairingOption() {
        pairingOption = inputView.readPairingOption();
        if (PairMatchingResults.hasPreviousMatching(pairingOption)) {
            return PairMatchingStatus.HANDLE_PREVIOUS_MATCHING;
        }
        return PairMatchingStatus.ATTEMPT_MATCHING;
    }

    private PairMatchingStatus handlePreviousMatching() {
        if (inputView.readRematchOption().isNo()) {
            return PairMatchingStatus.SELECT_PAIRING_OPTION;
        }
        return PairMatchingStatus.ATTEMPT_MATCHING;
    }

    private PairMatchingStatus attemptMatching() {
        PairMatchingResult result = new PairMatchingResult(pairingOption);
        if (PairMatchingResults.hasDuplicatedPairsInSameLevel(result)) {
            return PairMatchingStatus.HANDLE_DUPLICATED_PAIRS;
        }
        PairMatchingResults.addPairMatchingResult(pairingOption, result);
        return PairMatchingStatus.SUCCESS_MATCHING;
    }

    private PairMatchingStatus handleDuplicatedPairs() {
        addAttempts();
        if (isFail()) {
            outputView.printFailMatching();
            return PairMatchingStatus.FAIL_MATCHING;
        }
        return PairMatchingStatus.ATTEMPT_MATCHING;
    }

    private void addAttempts() {
        attempts++;
    }

    private boolean isFail() {
        return attempts == MAX_ATTEMPTS;
    }

}
