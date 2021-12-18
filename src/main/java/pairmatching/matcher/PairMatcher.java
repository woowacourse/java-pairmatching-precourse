package pairmatching.matcher;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.crew.Crew;
import pairmatching.crew.Position;
import pairmatching.mission.Mission;
import pairmatching.mission.MissionRepository;
import pairmatching.pair.Pair;

public class PairMatcher {

    private static final String ERR_DUPLICATED_PAIR = "페어가 매칭되어 있습니다.";
    private static final String ERR_MATCH_UNAVAILABLE = "매치가 불가능 합니다.";
    private static final int PAIR_COUNT = 2;
    private static final int ODD_PAIR_COUNT = 3;
    private static final int EVEN = 2;
    private static final int MAX_TRY = 3;

    public void matchPairs(Mission mission, List<Crew> crews, Position position) {
        List<Mission> missions = MissionRepository.findByLevel(mission.getLevel());
        missions.removeIf(m -> m.getName().equals(mission.getName()));
        crews.forEach(c -> System.out.println(c.getName()));
        List<Crew> copied = new ArrayList<>(crews);
        copied.forEach(c -> System.out.println(c.getName()));
        while (!copied.isEmpty()) {
            if (!match(missions, mission, copied, position)) {
                throw new IllegalArgumentException(ERR_MATCH_UNAVAILABLE);
            }
        }
    }

    private boolean match(List<Mission> missions, Mission mission, List<Crew> crews,
        Position position) {
        for (int i = 0; i < MAX_TRY; i++) {
            List<Crew> picked = pickCrew(crews);
            try {
                Pair pair = new Pair(position, picked);
                validateNeverMatched(pair, missions);
                mission.registerPair(pair);
                return true;
            } catch (IllegalArgumentException ignore) {
                crews.addAll(picked);
                Randoms.shuffle(crews);
            }
        }
        return false;
    }

    private List<Crew> pickCrew(List<Crew> crews) {
        List<Crew> picked = new ArrayList<>();
        int count = PAIR_COUNT;
        if (isOdd(crews.size())) {
            count = ODD_PAIR_COUNT;
        }
        for (int i = 0; i < count; i++) {
            picked.add(crews.remove(0));
        }
        return picked;
    }

    private void validateNeverMatched(Pair pair, List<Mission> missions) {
        if (missions.stream().anyMatch(m -> m.hasPair(pair))) {
            throw new IllegalArgumentException(ERR_DUPLICATED_PAIR);
        }
    }

    private boolean isOdd(int count) {
        return count % EVEN != 0;
    }
}
