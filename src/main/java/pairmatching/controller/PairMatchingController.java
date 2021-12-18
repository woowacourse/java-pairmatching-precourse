package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Function;
import pairmatching.domain.PairInfo;
import pairmatching.repository.PairInfoRepository;
import pairmatching.service.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private PairInfoRepository pairInfoRepository = new PairInfoRepository();
	private PairMatchingService pairMatchingService = new PairMatchingService();

	public PairMatchingController() throws IOException {
	}

	public void start() {
		selectFunction(inputView.readFunction());
	}

	public void selectFunction(Function function) {
		if (function == Function.PAIR_MATCHING) {
			implementPairMatching();
		}


	}

	public void implementPairMatching() {
		PairInfo pairInfo = inputView.readPairInfo();

		if (pairInfoRepository.contains(pairInfo)) {
			inputRematchOrExit();
		}

		pairMatchingService.match(pairInfo);
		pairInfoRepository.addPairInfo(pairInfo);
		outputView.printPairInfo(pairInfo);

		start();
	}

	private void inputRematchOrExit() {
		boolean answer = inputView.readRematchOrExit();

		if (!answer) {
			start();
		}
	}
}
