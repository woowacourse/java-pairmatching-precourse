package pairmatching.crew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMatching {
    public static List<List<String>> getPairedCrew(List<String> crew) {
        if (isOdd(crew)) {
            return matchOdd(crew);
        }
        return matchEven(crew);
    }

    public static boolean isOdd(List<String> crew) {
        if (crew.size() % 2 == 0) {
            return false;   // 짝수
        }
        return true;
    }

    public static List<List<String>> matchOdd(List<String> crew) {
        List<List<String>> pairCrew = new ArrayList<>();
        List<String> crews = crew;
        while (true) {
            if (crews.size() == 3) {
                List<String> pair = Arrays.asList(crews.get(0), crews.get(1), crews.get(2));
                pairCrew.add(pair);
                break;
            }
            List<String> pair = Arrays.asList(crews.get(0), crews.get(1));
            pairCrew.add(pair);
            crews.remove(0);
            crews.remove(1);
        }
        return pairCrew;
    }

    public static List<List<String>> matchEven(List<String> crew) {
        List<List<String>> pairCrew = new ArrayList<>();
        List<String> crews = crew;
        while (true) {
            if (crews.size() == 0) {
                break;
            }
            List<String> pair = Arrays.asList(crews.get(0), crews.get(1));
            pairCrew.add(pair);
            crews.remove(0);
            crews.remove(1);
        }
        return pairCrew;
    }
}
