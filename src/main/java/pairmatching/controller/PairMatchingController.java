package pairmatching.controller;

import static pairmatching.utils.Constant.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.MatchingInfo;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingRepository;
import pairmatching.service.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;


public class PairMatchingController {
	private final CrewRepository crewRepository = CrewRepository.getInstance();
	private final MatchingRepository matchingRepository = MatchingRepository.getInstance();
	private final PairMatchingService pairMatchingService = new PairMatchingService();

	public void run(List<String> pairMatchingInfos) {
		if (!pairMatchingService.isMatched(pairMatchingInfos)) {
			doPairMatching(pairMatchingInfos);
			return;
		}

		String userAnswer = InputView.inputRematchingAnswer();
		if (userAnswer.equals("네")) {
			List<String> result = matching(pairMatchingInfos);

			OutputView.showMatchingCrews(result);
		}
	}

	private void doPairMatching(List<String> pairMatchingInfos) {
		matchingRepository.saveMatchingInfo(pairMatchingInfos);
		List<String> shuffledCrews = matching(pairMatchingInfos);

		OutputView.showMatchingCrews(shuffledCrews);
	}

	private List<String> matching(List<String> pairMatchingInfos) {
		MatchingInfo matchingInfo = matchingRepository.findByInfo(pairMatchingInfos);

		String matchingCourse = pairMatchingInfos.get(COURSE_INFO);
		List<String> matchingCrews = crewRepository.findCrews(matchingCourse);
		List<String> shuffledCrews = Randoms.shuffle(matchingCrews);

		matchingInfo.updatePairMatchingList(shuffledCrews);
		return shuffledCrews;
	}
}
