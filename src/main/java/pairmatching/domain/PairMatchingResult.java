package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import pairmatching.domain.option.PairingOption;
import pairmatching.domain.repository.Crews;

public class PairMatchingResult {

    private final PairingOption pairingOption;
    private final List<Set<Crew>> pairMatchingResult;

    public PairMatchingResult(PairingOption pairingOption) {
        this.pairingOption = pairingOption;
        this.pairMatchingResult = pairMatch();
    }

    private List<Set<Crew>> pairMatch() {
        List<Crew> shuffledCrews = getShuffledCrews();
        if (isCrewNumberEven(shuffledCrews)) {
            return handleCrewsWithEvenNumber(shuffledCrews);
        }
        return handleCrewsWithOddNumber(shuffledCrews);
    }

    private static boolean isCrewNumberEven(List<Crew> shuffledCrews) {
        return shuffledCrews.size() % 2 == 0;
    }

    private static List<Set<Crew>> handleCrewsWithEvenNumber(List<Crew> shuffledCrews) {
        List<Set<Crew>> result = new ArrayList<>();
        for (int index = 0; index < shuffledCrews.size(); index += 2) {
            Set<Crew> pair = new LinkedHashSet<>();
            pair.add(shuffledCrews.get(index));
            pair.add(shuffledCrews.get(index + 1));
            result.add(pair);
        }
        return result;
    }

    private static List<Set<Crew>> handleCrewsWithOddNumber(List<Crew> shuffledCrews) {
        List<Set<Crew>> result = new ArrayList<>();
        for (int index = 0; index < shuffledCrews.size() - 3; index += 2) {
            Set<Crew> pair = new LinkedHashSet<>();
            pair.add(shuffledCrews.get(index));
            pair.add(shuffledCrews.get(index + 1));
            result.add(pair);
        }
        result.add(getLastPair(shuffledCrews));
        return result;
    }

    private static Set<Crew> getLastPair(List<Crew> shuffledCrews) {
        Set<Crew> lastPair = new LinkedHashSet<>();
        int lastIndex = shuffledCrews.size() - 1;
        lastPair.add(shuffledCrews.get(lastIndex));
        lastPair.add(shuffledCrews.get(lastIndex - 1));
        lastPair.add(shuffledCrews.get(lastIndex - 2));
        return lastPair;
    }


    private List<Crew> getShuffledCrews() {
        List<Crew> crews = Crews.getCrewsByCourse(pairingOption.getCourse());
        return toCrew(crews);
    }

    private static List<Crew> toCrew(List<Crew> crews) {
        return Randoms.shuffle(toName(crews)).stream()
                .map(element -> Crews.findCrewByName(element))
                .collect(Collectors.toList());
    }

    private static List<String> toName(List<Crew> crews) {
        return crews.stream().map(crew -> crew.getName()).collect(Collectors.toList());
    }

    public List<Set<Crew>> getPairMatchingResult() {
        return Collections.unmodifiableList(pairMatchingResult);
    }

    public PairingOption getPairingOption() {
        return pairingOption;
    }
}
