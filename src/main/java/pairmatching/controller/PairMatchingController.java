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

		if (findInfo == null) {
			// todo 예외처리하기
			implementPairCheck();
			return;
		}

		outputView.printPairInfo(findInfo);

		start();
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
