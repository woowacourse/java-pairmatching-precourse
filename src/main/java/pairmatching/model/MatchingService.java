package pairmatching.model;

import java.util.List;
import java.util.Map;

import pairmatching.controller.MatchingController;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.view.MatchingMessage;

public class MatchingService {
	public static void start(List<String> domainList, List<String> crews) {
		if (check(domainList)) {
			Crew.shuffle(crews);
			Map<String, List<String>> pairMap = Pair.create(domainList, crews);
			MatchingMessage.printPairList(pairMap.get(String.join("", domainList)));
		}

		if (!check(domainList)) {
			Operation.selectDomain();
		}
	}

	public static boolean check(List<String> domainList) {
		if (Pair.isAlreadyMatched(domainList)) {
			String answer = MatchingController.askRematching();
			return !answer.equals("아니오");
		}
		return true;
	}
}
