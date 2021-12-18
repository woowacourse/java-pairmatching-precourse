package pairmatching.model;

import java.util.List;
import java.util.Map;

import pairmatching.domain.Pair;
import pairmatching.view.MatchingMessage;

public class LookUpService {
	public static void start(List<String> domainList) {
		Map<String, List<String>> pairMap = Pair.getInstance();
		MatchingMessage.printPairList(pairMap.get(String.join("", domainList)));
	}
}
