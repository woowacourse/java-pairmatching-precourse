package pairmatching.domain.pair;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.List;
import java.util.Objects;

public class Pair {

    private final List<Crew> pair;

    private Pair(final List<Crew> pair) {
        this.pair = pair;
    }

    public static Pair valueOf(List<String> names) {
        return new Pair(names.stream()
                .map(Crew::new)
                .collect(toUnmodifiableList()));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (null == o || this.getClass() != o.getClass()) {
            return false;
        }
        final Pair otherPair = (Pair) o;
        return pair.equals(otherPair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pair);
    }

    @Override
    public String toString() {
        return pair.stream()
                .map(crew -> crew.toString())
                .collect(joining(" : "));
    }
}
