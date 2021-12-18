package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Mission;
import pairmatching.domain.PairInfo;

public class PairInfoRepository {

	private static List<PairInfo> pairInfoList = new ArrayList<>();

	public void addPairInfo(PairInfo pairInfo) {
		pairInfoList.add(pairInfo);
	}

	public PairInfo getByInfo(Course course, Mission mission) {
		return pairInfoList.stream()
			.filter(pairInfo ->
				pairInfo.equals(new PairInfo(course, mission)))
			.findFirst()
			.orElse(null);
	}

	public boolean contains(PairInfo pairInfo) {
		return pairInfoList.contains(pairInfo);
	}
}
