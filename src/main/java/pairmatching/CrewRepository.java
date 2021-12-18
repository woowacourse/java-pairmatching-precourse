package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import pairmatching.exception.ErrorMessage;

public class CrewRepository {
    private static final int MAX_SHUFFLE_COUNT = 3;
    private static final int SHUFFLE_COUNT = 1;

    private static final List<Crew> crews = new ArrayList<>();

    private CrewRepository() {}

    public static void addCrew(Crew crew) {
        crews.add(crew);
    }

    public static List<String> findAllByCourse(Course course) {
        return crews.stream()
            .filter(crew -> crew.isEqualToCourse(course))
            .map(Crew::getName)
            .collect(Collectors.toList());
    }

    public static List<Pair> matchingCrews(List<String> shuffle, Level level, int shuffleCount) {
        validateMaxCount(shuffleCount);
        List<Pair> pairs = new ArrayList<>();
        Queue<String> queue = new LinkedList<>(shuffle);
        addPair(level, pairs, queue);
        if (pairs.isEmpty()) {
            matchingCrews(Randoms.shuffle(shuffle), level, shuffleCount + SHUFFLE_COUNT);
        }
        return pairs;
    }

    private static void addPair(Level level, List<Pair> pairs, Queue<String> queue) {
        while (!queue.isEmpty()) {
            Pair pair = null;
            if (queue.size() >= 2) {
                pair = Pair.createPair(findByName(queue.poll()), findByName(queue.poll()));
            }
            if (queue.size() == 1) {
                pair.addCrew(findByName(queue.poll()));
            }

            if (!isEqualsLevel(pair, level)) {
                pairs.clear();
                break;
            }
            pairs.add(pair);
        }
    }

    private static void validateMaxCount(int shuffleCount) {
        if (shuffleCount == MAX_SHUFFLE_COUNT) {
            System.out.println(shuffleCount);
            throw ErrorMessage.NOT_SHUFFLE.getException();
        }
    }

    private static Crew findByName(String name) {
        return crews.stream().filter(crew -> crew.isEqualToName(name)).findAny().get();
    }

    private static boolean isEqualsLevel(Pair pair, Level level) {
        List<Crew> crews = pair.getCrews();
        for (Crew crew : crews) {
            if (crew.isEqualToLevel(level)) {
                return false;
            }
            crew.addLevel(level);
        }
        return true;
    }
}
