package pairmatching.domain.pairMatcher;

public class Pair {
    private String crew1;
    private String crew2;
    private String crew3;
    Pair(String crew1, String crew2) {
        this.crew1 = crew1;
        this.crew2 = crew2;
    }

    Pair(String crew1, String crew2, String crew3) {
        this.crew1 = crew1;
        this.crew2 = crew2;
        this.crew3 = crew3;
    }
}
