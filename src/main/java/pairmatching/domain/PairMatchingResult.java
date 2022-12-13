package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.option.PairingOption;
import pairmatching.domain.repository.Crews;

public class PairMatchingResult {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairMatchingResult(PairingOption pairingOption) {
        this.course = pairingOption.getCourse();
        this.level = pairingOption.getLevel();
        this.mission = pairingOption.getMission();
    }

    public void pairMatch() {

        List<Crew> shuffledCrews = getShuffledCrews();
        List<List<Crew>> result = new ArrayList<>();

        if (shuffledCrews.size() % 2 == 0) {
            for (int index = 0; index < shuffledCrews.size(); index += 2) {
                List<Crew> pair = new ArrayList<>();
                pair.add(shuffledCrews.get(index));
                pair.add(shuffledCrews.get(index + 1));
                result.add(pair);
            }
        }

        if (shuffledCrews.size() % 2 != 0) {

            for (int index = 0; index < shuffledCrews.size() - 3; index += 2) {
                List<Crew> pair = new ArrayList<>();
                pair.add(shuffledCrews.get(index));
                pair.add(shuffledCrews.get(index + 1));
                result.add(pair);
            }

            List<Crew> lastPair = new ArrayList<>();
            int lastIndex = shuffledCrews.size() - 1;
            lastPair.add(shuffledCrews.get(lastIndex));
            lastPair.add(shuffledCrews.get(lastIndex - 1));
            lastPair.add(shuffledCrews.get(lastIndex - 2));
            result.add(lastPair);
        }

    }

    private List<Crew> getShuffledCrews() {
        List<Crew> crews = Crews.getCrewsByCourse(course);
        List<Crew> shuffledCrews = toCrew(crews);
        return shuffledCrews;
    }

    private static List<Crew> toCrew(List<Crew> crews) {
        return Randoms.shuffle(toName(crews)).stream()
                .map(element -> Crews.findCrewByName(element))
                .collect(Collectors.toList());
    }

    private static List<String> toName(List<Crew> crews) {
        return crews.stream().map(crew -> crew.getName()).collect(Collectors.toList());
    }
}
