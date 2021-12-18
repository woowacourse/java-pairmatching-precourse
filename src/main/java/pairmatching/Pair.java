package pairmatching;

import java.util.List;

public class Pair {

    List<Crew> crews;

    public Pair() {
        PairManager pairManager = new PairManager();
        this.crews = pairManager.registerCrews();
    }

    public void startPairing() {

    }
}
