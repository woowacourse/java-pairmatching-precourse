package pairmatching;

public class Pair {
    private static final String DELIMITER = " : ";
    private Crew crew1;
    private Crew crew2;

    public Pair(Crew crew1, Crew crew2) {
        this.crew1 = crew1;
        this.crew2 = crew2;
    }

    public void update(int level) {
        crew1.push(crew2, level);
        crew2.push(crew1, level);
    }

    public String toString() {
        return crew1.getName() + DELIMITER + crew2.getName();
    }
}
