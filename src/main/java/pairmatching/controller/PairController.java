package pairmatching.controller;

import java.util.function.Supplier;

import pairmatching.controller.dto.request.PairRequest;
import pairmatching.domain.Pairs;
import pairmatching.service.CrewService;
import pairmatching.service.MatchingService;
import pairmatching.view.ClearPairView;
import pairmatching.view.FunctionRequestView;
import pairmatching.view.PairRequestView;
import pairmatching.view.PairResponseView;
import pairmatching.view.RematchRequestView;
import pairmatching.view.console.ConsoleWriter;

public class PairController {
	private final CrewService crewService;
	private final MatchingService matchingService;

	public PairController(
		CrewService crewService,
		MatchingService matchingService
	) {
		this.crewService = crewService;
		this.matchingService = matchingService;
	}

	public void run() {
		while (true) {
			String input = FunctionRequestView.request();
			if (input == "Q") {
				break;
			}
			if (input == "1") {
				savePairs();
			}
			if (input == "2") {
				getPairs();
			}
			if (input == "3") {
				clearPairs();
			}
		}
	}

	// 페어 매칭 기능
	public void savePairs() {
		PairRequest matchingRequest = getMatchingRequest();
		Pairs pairs = matchingService.generateMatching(
			matchingRequest.course(),
			matchingRequest.mission()
		);
		PairResponseView.response(pairs);
	}

	public PairRequest getMatchingRequest() {
		while (true) {
			PairRequest pairRequest = PairRequestView.request();
			if (matchingService.hasNoPairs(pairRequest.mission())) {
				return pairRequest;
			}
			// 이미 매칭된 미션인 경우
			boolean rematch = RematchRequestView.request();
			if (rematch) {
				return pairRequest;
			}
		}
	}

	// 페어 조회 기능
	public void getPairs() {
		Pairs pairs = retry(() -> {
			return matchingService.getPairs(
				PairRequestView.request().mission()
			);
		});
		PairResponseView.response(pairs);
	}

	// 페어 초기화 기능
	public void clearPairs() {
		matchingService.clear();
		ClearPairView.response();
	}

	private static <T> T retry(Supplier<T> supplier) {
		while (true) {
			try {
				return supplier.get();
			} catch (IllegalArgumentException e) {
				ConsoleWriter.printlnMessage(e.getMessage());
			}
		}
	}
}
