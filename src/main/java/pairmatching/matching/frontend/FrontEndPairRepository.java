package pairmatching.matching.frontend;

import pairmatching.crew.Level;
import pairmatching.matching.Pair;
import java.util.ArrayList;
import java.util.List;

public class FrontEndPairRepository {

    private List<Pair> pairs = new ArrayList<>();

    private FrontEndPairRepository(){}

    private static class InnerInstanceClazz {
        private static FrontEndPairRepository instance = new FrontEndPairRepository();
    }

    public static FrontEndPairRepository getInstance() {
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
