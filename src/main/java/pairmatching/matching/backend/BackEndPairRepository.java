package pairmatching.matching.backend;

import pairmatching.crew.Level;
import pairmatching.matching.Pair;
import java.util.ArrayList;
import java.util.List;

public class BackEndPairRepository {

    private List<Pair> pairs = new ArrayList<>();

    private BackEndPairRepository(){}

    private static class InnerInstanceClazz {
        private static BackEndPairRepository instance = new BackEndPairRepository();
    }

    public static BackEndPairRepository getInstance() {
        return InnerInstanceClazz.instance;
    }

    public void add(Pair pair) {
        pairs.add(pair);
    }

    public List<Pair> findAllByLevel(Level level) {
        List<Pair> sameLevelPairs = new ArrayList<>();
        for(Pair pair : pairs) {
            if(pair.isSameLevel(level))
                sameLevelPairs.add(pair);
        }
        return sameLevelPairs;
    }
}
