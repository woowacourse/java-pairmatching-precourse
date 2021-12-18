package pairmatching.domain.matcher;

public class PairController {
    private PairHistory pairHistory;
    private Pairs pairs;

    public PairController(PairHistory pairHistory, Pairs pairs) {
        this.pairHistory = pairHistory;
        this.pairs = pairs;
    }

    public Pairs getPairs() {
        return pairs;
    }

    public PairHistory getPairHistory() {
        return pairHistory;
    }
}
