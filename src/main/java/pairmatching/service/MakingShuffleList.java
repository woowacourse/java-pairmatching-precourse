package pairmatching.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class MakingShuffleList {
	public static List<String> shuffle(List<String> memberList) {
		List<String> shuffleMemberList = Randoms.shuffle(memberList);
		return shuffleMemberList;
	}

	public static void printPairList(List<String> pairList) {
		System.out.println("\n페어 매칭 결과입니다.");

		for (int i = 0; i < pairList.size() / 2; i++) {

			if (i == pairList.size() / 2 - 1) {
				System.out.print(pairList.get(i * 2) + " : " + pairList.get(i * 2 + 1));
				break;
			}

			System.out.println(pairList.get(i * 2) + " : " + pairList.get(i * 2 + 1));
		}

		if (pairList.size() % 2 != 0) {
			System.out.print(" : " + pairList.get(pairList.size() - 1));
		}

		System.out.println("\n");
	}
}
