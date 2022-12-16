package pairmatching.domain;

public class Crew {
    private String name;

    public Crew(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
