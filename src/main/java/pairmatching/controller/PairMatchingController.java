package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Function;
import pairmatching.domain.PairInfo;
import pairmatching.repository.PairInfoRepository;
import pairmatching.service.PairMatchingService;
import pairmatching.validator.PairValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private PairInfoRepository pairInfoRepository = new PairInfoRepository();
	private PairMatchingService pairMatchingService = new PairMatchingService();
	private PairValidator pairValidator = new PairValidator();

	public PairMatchingController() throws IOException {
	}

	public void start() {
		selectFunction(inputView.readFunction());
	}

	public void selectFunction(Function function) {
		if (function == Function.PAIR_MATCHING) {
			implementPairMatching();
		}

		if (function == Function.PAIR_CHECK) {
			implementPairCheck();
		}

		if (function == Function.PAIR_RESET) {
			implementPairReset();
		}

		if (function == Function.EXIT) {
			outputView.printExit();
		}
	}

	public void implementPairReset() {
		pairInfoRepository.clear();
		start();
	}

	public void implementPairCheck() {
		PairInfo pairInfo = inputView.readPairInfo();

		PairInfo findInfo = pairInfoRepository.getByInfo(pairInfo.getCourse(), pairInfo.getMission());

		validatePairInfo(findInfo);

		outputView.printPairInfo(findInfo);

		start();
	}

	private void validatePairInfo(PairInfo findInfo) {
		try {
			pairValidator.validatePairInfo(findInfo);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			implementPairCheck();
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
