package pairmatching.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandonUtil {

    private RandonUtil() {

    }

    public static List<String> shuffle(List<String> elements) {
        return Randoms.shuffle(elements);
    }
}
