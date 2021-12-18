package pairmatching;

public class Pair {
    private static final String DELIMITER = " : ";
    private Crew crew1;
    private Crew crew2;
    private Crew crew3;

    public Pair(Crew crew1, Crew crew2) {
        this.crew1 = crew1;
        this.crew2 = crew2;
    }

    public Pair(Crew crew1, Crew crew2, Crew crew3) {
        this.crew1 = crew1;
        this.crew2 = crew2;
        this.crew3 = crew3;
    }

    public void update(int level) {
        crew1.push(crew2, level);
        crew2.push(crew1, level);
    }

    public void updateThird(int level) {
        crew1.push(crew2, level);
        crew1.push(crew3, level);
        crew2.push(crew1, level);
        crew2.push(crew3, level);
        crew3.push(crew1, level);
        crew3.push(crew2, level);
    }

    public String toString() {
        String data = crew1.getName() + DELIMITER + crew2.getName();
        if (crew3 != null) {
            data = data + DELIMITER + crew3.getName();
        }
        return data;
    }

}
