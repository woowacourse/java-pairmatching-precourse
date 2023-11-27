package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public abstract class CrewMatcher {
    abstract public Set<Pair> matching(List<String> crewName);
}
