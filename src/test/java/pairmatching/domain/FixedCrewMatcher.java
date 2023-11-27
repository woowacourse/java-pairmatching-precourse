package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FixedCrewMatcher extends CrewMatcher{
    @Override
    public Set<Pair> matching(List<String> crewName) {
        Queue<String> names = new LinkedList<>(crewName);
        System.out.println(names);
        Set<Pair> pairs = new HashSet<>();
        while (names.size() > 3) {
            pairs.add(new Pair(names.poll(), names.poll()));
        }
        pairs.add(new Pair(names));

        return pairs;
    }
}
