package pairmatching.domain.matching;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.choice.Choice;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.item.Course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PairMatchingMachine {

    private static final String BACKEND_CREW_PATH = "C:\\programming\\woowacourse\\practice\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";
    private static final String FRONTEND_CREW_PATH = "C:\\programming\\woowacourse\\practice\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md";
    private static final int BASIC_PAIR_SIZE = 2;
    private static final int SPECIAL_PAIR_SIZE = 3;
    private static final int START_NUMBER = 1;

    public List<Set<Crew>> makePairs(Choice choice) throws IOException {
        if (choice.hasCourseOf(Course.BACKEND)) {
            List<Crew> shuffledCrews = readShuffledCrews(BACKEND_CREW_PATH);
            return makePairsBy(shuffledCrews);
        }
        List<Crew> shuffledCrews = readShuffledCrews(FRONTEND_CREW_PATH);
        return makePairsBy(shuffledCrews);
    }

    private List<Set<Crew>> makePairsBy(List<Crew> shuffledCrews) {
        List<Set<Crew>> pairs = new ArrayList<>();
        int halfSize = shuffledCrews.size() / BASIC_PAIR_SIZE;
        for (int i = 0; i < halfSize; i++) {
            pairs.add(makeCrewPairByOrder(shuffledCrews, halfSize, i));
        }
        return pairs;
    }

    private Set<Crew> makeCrewPairByOrder(List<Crew> shuffledCrews, int halfSize, int order) {
        if (order == halfSize - START_NUMBER) {
            return makePair(shuffledCrews, order * BASIC_PAIR_SIZE, SPECIAL_PAIR_SIZE);
        }
        return makePair(shuffledCrews, order * BASIC_PAIR_SIZE, BASIC_PAIR_SIZE);
    }

    private static Set<Crew> makePair(List<Crew> shuffledCrews, int skipSize, int pairSize) {
        return shuffledCrews.stream()
                .skip(skipSize)
                .limit(pairSize)
                .collect(Collectors.toSet());
    }

    private List<Crew> readShuffledCrews(String path) throws IOException {
        List<String> shuffledNames = Randoms.shuffle(readNames(path));
        return shuffledNames.stream()
                .map(name -> new Crew(Course.BACKEND, name))
                .collect(Collectors.toList());
    }

    public List<String> readNames(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}
