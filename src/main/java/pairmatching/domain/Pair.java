package pairmatching.domain;

public class Pair {
    private final Crew crew1;
    private final Crew crew2;

    public Pair(Crew crew1, Crew crew2) {
        this.crew1 = crew1;
        this.crew2 = crew2;
    }

    // 페어가 순서 상관없이 일치하는지 반환
    public boolean isEqualTo(Crew crew1, Crew crew2){
        return (this.crew1.matches(crew1) && this.crew2.matches(crew2)) || (this.crew1.matches(crew2) && this.crew2.matches(crew1));
    }
}
