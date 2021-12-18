package pairmatching.repository;

import pairmatching.domain.MatchingInfo;
import pairmatching.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class MatchingRepository {
	private static final MatchingRepository instance = new MatchingRepository();

	private List<MatchingInfo> matchingInfos = new ArrayList<>();

	private MatchingRepository() {

	}

	public static MatchingRepository getInstance() {
		if (instance == null) {
			return new MatchingRepository();
		}
		return instance;
	}

	public void saveMatchingInfo(List<String> infos) {
		MatchingInfo matchingInfo = new MatchingInfo(infos);
		matchingInfos.add(matchingInfo);
	}

	public MatchingInfo findByInfo(List<String> infos) {
		return matchingInfos.stream()
				.filter(m -> m.isSame(infos))
				.findFirst().orElse(null);
	}

	public void resetMatchingInfo() {
		matchingInfos.clear();
	}

	public List<MatchingInfo> findAll() {
		return this.matchingInfos;
	}
}
