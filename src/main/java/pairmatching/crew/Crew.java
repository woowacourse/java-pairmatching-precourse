package pairmatching.crew;

public class Crew {

    private final String name;
    private final Position position;

    public Crew(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
