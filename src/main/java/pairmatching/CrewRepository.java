package pairmatching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class CrewRepository {

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

    public static List<Pair> matchingCrews(List<String> shuffle, Level level) {
        List<Pair> pairs = new ArrayList<>();
        Queue<String> queue = new LinkedList<>(shuffle);
        while (!queue.isEmpty()) {
            Pair pair = null;
            if (queue.size() >= 2) {
                pair = Pair.createPair(findByName(queue.poll()), findByName(queue.poll()));
            }
            if (queue.size() == 1) {
                pair.addCrew(findByName(queue.poll()));
            }
            pairs.add(pair);
        }
        return pairs;
    }

    private static Crew findByName(String name) {
        return crews.stream().filter(crew -> crew.isEqualToName(name)).findAny().get();
    }
}
