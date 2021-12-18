package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.util.Constant;

public class MatchGenerator {

    public List<Pair> createPairs(Options options, FileScanner scanner) {
        List<Crew> crews = scanner.crewFileScanner(options.getCourse());
        List<Pair> pairs = new ArrayList<>();
        List<Crew> shuffledCrew = Randoms.shuffle(crews);
        if (shuffledCrew.size() % Constant.EVEN_NUMBER_LIMIT == Constant.EMPTY) {
            return createEvenNumberPair(shuffledCrew, pairs);
        }
        return createEvenNumberPair(shuffledCrew, pairs);
    }

    public List<Pair> createOddNumberPair(List<Crew> crews, List<Pair> pairs) {
        int index = Constant.EMPTY;
        while (index < crews.size() - Constant.EVEN_NUMBER_LIMIT) { // 여기 잘 볼 것
            Pair pair = createPair();
            pair.addPair(crews.get(index));
            pair.addPair(crews.get(index + Constant.MATCH_INCREASE_VALUE));
            pairs.add(pair);
            index = index + 2;
        }
        Pair pair = createPair();
        pair.addPair(crews.get(index));
        pair.addPair(crews.get(index + 1));
        pair.addPair(crews.get(index + 2));
        pairs.add(pair);
        return pairs;
    }

    public List<Pair> createEvenNumberPair(List<Crew> crews, List<Pair> pairs) {
        int index = Constant.EMPTY;
        while (index < crews.size()) { // 여기 잘 볼 것
            Pair pair = createPair();
            pair.addPair(crews.get(index));
            pair.addPair(crews.get(index + Constant.MATCH_INCREASE_VALUE));
            pairs.add(pair);
            index = index + 2;
        }
        return pairs;
    }

    public Pair createPair() {
        return new Pair();
    }
}
