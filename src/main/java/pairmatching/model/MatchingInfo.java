package pairmatching.model;

import static pairmatching.constants.Constants.*;
import static pairmatching.constants.ErrorMessage.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import pairmatching.view.OutputView;

public class MatchingInfo {
	private Map<String, List<Pair>> matchingInfo;

	public MatchingInfo() {
		matchingInfo = new LinkedHashMap<>();
	}

	public void addInfo(String[] courseInfos, List<Pair> pairList) {
		String join = String.join(SPLIT_DELIMETER, courseInfos);
		matchingInfo.put(join, pairList);
	}

	public void printMatchingInfo(String course) {
		List<Pair> pairList = matchingInfo.get(course);
		if (pairList == null) {
			throw new IllegalArgumentException(PAIR_NOT_EXIST);
		}
		OutputView.printPairs(pairList);
	}
}
