package pairmatching;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.crew.Crew;
import pairmatching.crew.Position;
import pairmatching.pair.Pair;

public class PairTest {

    @Test
    void equal() {
        List<Crew> list = new ArrayList<>();
        list.add(new Crew("a", Position.BACKEND));
        list.add(new Crew("b", Position.BACKEND));
        Pair pair = new Pair(Position.BACKEND, list);
        List<Crew> list2 = new ArrayList<>();
        list2.addAll(list);
        list2.add(new Crew("c", Position.BACKEND));
        Pair pair2 = new Pair(Position.BACKEND, list2);
        assert !pair.equals(pair2);
    }
}
