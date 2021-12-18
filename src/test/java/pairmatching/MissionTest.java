package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
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
}
