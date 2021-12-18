package pairmatching.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {
	public static List<String> shuffleCrew(List<String> crews) {
		return Randoms.shuffle(crews);
	}
}
