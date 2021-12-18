package pairmatching.domain;

public class Pair {
    private Crew crew_1;
    private Crew crew_2;

    public Pair() {

    }

    @Override
    public String toString() {
        return "Pair{" +
                "crew_1=" + crew_1 +
                ", crew_2=" + crew_2 +
                '}';
    }
}
