package pairmatching.crew;

import java.util.List;

public class PairMatching {
    public static boolean isOdd(List<String> crew) {
        if (crew.size() % 2 == 0) {
            return false;   // 짝수
        }
        return true;
    }

    
}
