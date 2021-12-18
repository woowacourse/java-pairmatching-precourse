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
        List<String> copied = crews.stream().map(Crew::getName).collect(Collectors.toList());
        List<String> shuffled = new ArrayList<>(Randoms.shuffle(copied));
        while (!shuffled.isEmpty()) {
            if (!match(missions, mission, shuffled, position)) {
                throw new IllegalArgumentException(ERR_MATCH_UNAVAILABLE);
            }
        }
    }

    private boolean match(List<Mission> missions, Mission mission, List<String> names,
        Position position) {
        for (int i = 0; i < MAX_TRY; i++) {
            List<String> picked = pickCrew(names);
            try {
                Pair pair = new Pair(position, picked.stream()
                    .map(s -> new Crew(s, position)).collect(Collectors.toList()));
                validateNeverMatched(pair, missions);
                mission.registerPair(pair);
                return true;
            } catch (IllegalArgumentException ignore) {
                names.addAll(picked);
                names = new ArrayList<>(Randoms.shuffle(names));
            }
        }
        return false;
    }

    private List<String> pickCrew(List<String> crews) {
        List<String> picked = new ArrayList<>();
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
