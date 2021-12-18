package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.PairInfo;

public class PairInfoRepository {

	private static List<PairInfo> pairInfoList = new ArrayList<>();

	public boolean contains(PairInfo pairInfo) {
		return pairInfoList.contains(pairInfo);
	}
}
