package pairmatching.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandonUtil {

    private RandonUtil() {

    }

    public List<String> suffle(List<String> elements) {
        return Randoms.shuffle(elements);
    }
}
