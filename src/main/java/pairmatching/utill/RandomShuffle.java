package pairmatching.utill;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomShuffle {
	public static List<String> shuffleNames(List<String> nameList) {
		return Randoms.shuffle(nameList);
	}
}
