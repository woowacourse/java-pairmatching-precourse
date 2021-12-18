package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.util.Constant;

public class MatchGenerator {

    public List<Pair> createPairs(Options options, FileScanner scanner) {
        List<String> crews = scanner.nameFileScanner(options.getCourse());
        List<Pair> pairs = new ArrayList<>();
        List<String> shuffledCrew = Randoms.shuffle(crews);
        if (shuffledCrew.size() % Constant.EVEN_NUMBER_LIMIT == Constant.EMPTY) {
            return createEvenNumberPair(options, shuffledCrew, pairs);
        }
        return createOddNumberPair(options, shuffledCrew, pairs);
    }

    public List<Pair> createOddNumberPair(Options options, List<String> names, List<Pair> pairs) {
        int index = Constant.EMPTY;
        while (index < names.size() - Constant.ODD_NUMBER_LIMIT) {
            Pair pair = createPair();
            pair.addPair(new Crew(options.getCourse(), names.get(index)));
            pair.addPair(new Crew(options.getCourse(), names.get(index + Constant.MATCH_INCREASE_VALUE)));
            pairs.add(pair);
            index = index + Constant.INCREASE_VALUE;
        }
        Pair pair = createPair();
        pair.addPair(new Crew(options.getCourse(), names.get(index)));
        pair.addPair(new Crew(options.getCourse(), names.get(index + 1)));
        pair.addPair(new Crew(options.getCourse(), names.get(index + 2)));
        pairs.add(pair);
        return pairs;
    }

    public List<Pair> createEvenNumberPair(Options options, List<String> names, List<Pair> pairs) {
        int index = Constant.EMPTY;
        while (index < names.size()) {
            Pair pair = createPair();
            pair.addPair(new Crew(options.getCourse(), names.get(index)));
            pair.addPair(new Crew(options.getCourse(), names.get(index + Constant.MATCH_INCREASE_VALUE)));
            pairs.add(pair);
            index = index + Constant.INCREASE_VALUE;
        }
        return pairs;
    }

    public Pair createPair() {
        return new Pair();
    }
}
