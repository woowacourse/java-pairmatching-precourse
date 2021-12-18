package pairmatching.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

    public static List<String> generateRandomMatching(List<String> names) {
        return Randoms.shuffle(names);
    }
}
