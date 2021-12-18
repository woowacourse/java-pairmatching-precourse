package pairmatching.crew;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Crew crew = (Crew) o;

        if (!Objects.equals(name, crew.name)) {
            return false;
        }
        return position == crew.position;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
