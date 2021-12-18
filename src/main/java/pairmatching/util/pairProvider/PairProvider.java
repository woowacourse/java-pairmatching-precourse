package pairmatching.util.pairProvider;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.course.Course;
import pairmatching.domain.pair.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class PairProvider {
    private static Queue<String> allNameQueue;

    public static Set<Pair> getPairsRandomly(List<String> nameList, Course course) {
        Randoms.shuffle(nameList);
        allNameQueue = nameList.stream().collect(Collectors.toCollection(LinkedList::new));

        return getPairSet(course);
    }

    private static Set<Pair> getPairSet(Course course) {
        Set<Pair> pairs = new HashSet<>();

        while(!allNameQueue.isEmpty()) {
            if(isThree()) {
                pairs.add(makeOddPair(course));
                return pairs;
            }
            pairs.add(makeEvenPair(course));
        }

        return pairs;
    }

    private static boolean isThree() {
        return allNameQueue.size() == 3;
    }

    private static Pair makeEvenPair(Course course) {
        return Pair.of(allNameQueue.poll(), allNameQueue.poll(), course);
    }

    private static Pair makeOddPair(Course course) {
        return Pair.of(allNameQueue.poll(), allNameQueue.poll(),allNameQueue.poll(), course);
    }
}
