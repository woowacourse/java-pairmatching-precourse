package pairmatching;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import pairmatching.controller.PairMatchingController;
import pairmatching.crew.Crew;
import pairmatching.crew.Position;
import pairmatching.matcher.PairMatcher;
import pairmatching.mission.Mission;
import pairmatching.mission.MissionRepository;
import pairmatching.pair.Pair;
import pairmatching.utils.CrewListInitializer;

public class MissionTest {

    @Test
    void pairmatch() {
        PairMatcher matcher = new PairMatcher();
        Mission mission = MissionRepository.findByName("로또");
        List<Crew> crews = CrewListInitializer.getBackendCrews();
        matcher.matchPairs(mission, crews, Position.BACKEND);
        Set<Pair> pairs = mission.getMatchedPair(Position.BACKEND);
        pairs.forEach(p -> System.out.println(p.getMatching()));
    }

    @Test
    void matchTest() {
        List<Crew> crews = Arrays.asList("a", "b", "c", "b", "0", "1").stream()
            .map(s -> new Crew(s, Position.BACKEND))
            .collect(Collectors.toList());
        PairMatcher matcher = new PairMatcher();
        Mission mission = MissionRepository.findByName("로또");
        matcher.matchPairs(mission, crews, Position.BACKEND);
        System.out.println(mission.getMatchedResult(Position.BACKEND));
    }

    @Test
    void match() {
        PairMatchingController controller = new PairMatchingController();
        controller.invalidAllPairs();
    }
}
