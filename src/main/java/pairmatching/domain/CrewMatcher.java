package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CrewMatcher {
    public Set<Pair> matching(List<String> crewName) {
        Queue<String> shuffledName = new LinkedList<>(Randoms.shuffle(crewName));
        System.out.println(shuffledName);
        Set<Pair> pairs = new HashSet<>();
        while(shuffledName.size() > 3){
            pairs.add(new Pair(shuffledName.poll(), shuffledName.poll()));
        }
        pairs.add(new Pair(shuffledName));

        return pairs;
    }
}
