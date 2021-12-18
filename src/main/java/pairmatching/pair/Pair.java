package pairmatching.pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.crew.Crew;
import pairmatching.crew.Position;

public class Pair {

    private static final String ERR_OVER_MAXSIZE = "최대 3명까지만 매칭이 가능합니다.";
    private static final String ERR_POSITION_UNMATCHED = "포지션은 같아야합니다.";
    private static final int MAX_SIZE = 3;
    private static final int MIN_SIZE = 2;
    private final Position position;
    private final Set<Crew> pair = new HashSet<>();

    public Pair(Position position, List<Crew> crews) {
        this.position = position;
        validateCrewCount(crews);
        validatePosition(crews);
        this.pair.addAll(crews);
    }

    private void validatePosition(List<Crew> crews) {
        if (!crews.stream().allMatch(c -> c.getPosition() == this.position)) {
            throw new IllegalArgumentException(ERR_POSITION_UNMATCHED);
        }
    }

    private void validateCrewCount(List<Crew> crews) {
        if (crews.size() < MIN_SIZE || crews.size() > MAX_SIZE) {
            throw new IllegalArgumentException(ERR_OVER_MAXSIZE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair target = (Pair) o;

        return pair.equals(target.pair);
    }

    @Override
    public int hashCode() {
        return pair.hashCode();
    }
}
