package pairmatching.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class MakingShuffleList {
	public static List<String> shuffle(List<String> memberList) {
		List<String> shuffleMemberList = Randoms.shuffle(memberList);
		return shuffleMemberList;
	}
}
