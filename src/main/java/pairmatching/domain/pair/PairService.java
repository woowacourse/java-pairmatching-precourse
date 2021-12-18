package pairmatching.domain.pair;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairService {

    private static final int FIRST_CREW_INDEX = 0;
    private static final int SECOND_CREW_INDEX = 1;
    private static final int THIRD_CREW_INDEX = 2;

    private final List<String> frontend;
    private final List<String> backend;

    public PairService(List<String> frontend, List<String> backend) {
        this.frontend = frontend;
        this.backend = backend;
    }

    public List<Pair> makePairs(PairTag pairTag) {
        PairRepository.clear(pairTag);

        int count = 0;
        do {
            List<Pair> pairs = loadPairsWithShuffle(pairTag);
            if (!isDuplicatePair(pairs, pairTag)) {
                PairRepository.save(pairTag, pairs);
                return pairs;
            }
            count++;
        } while (count < 3);

        throw new IllegalArgumentException("[ERROR] 이미 페어가 존재하거나 매칭을 할 수 없습니다.");
    }

    private List<Pair> loadPairsWithShuffle(PairTag pairTag) {
        List<Pair> result = new ArrayList<>();
        List<Crew> shuffledCrew = null;
        if (pairTag.getCourse() == Course.BACKEND) {
            shuffledCrew = mapNamesToCrews(backend, Course.BACKEND);
        }
        if (pairTag.getCourse() == Course.FRONTEND) {
            shuffledCrew = mapNamesToCrews(frontend, Course.FRONTEND);
        }

        mappingPairs(pairTag, result, shuffledCrew);
        if (isOddSizeCrews(shuffledCrew)) {
            addLastCrewInLastPair(result, shuffledCrew);
        }
        return result;
    }

    private void addLastCrewInLastPair(List<Pair> result, List<Crew> shuffledCrew) {
        Pair pair = result.get(result.size() - 1);
        pair.addCrew(shuffledCrew.get(shuffledCrew.size() - 1));
    }

    private boolean isOddSizeCrews(List<Crew> shuffledCrew) {
        return shuffledCrew.size() % 2 != 0;
    }

    private void mappingPairs(PairTag pairTag, List<Pair> result, List<Crew> shuffledCrew) {
        int index = 0;
        while (index < shuffledCrew.size() - 1) {
            addCrewsInPair(pairTag, result, shuffledCrew, index);
            index += 2;
        }
    }

    private void addCrewsInPair(PairTag pairTag, List<Pair> result, List<Crew> shuffledCrew, int index) {
        Crew crewOne = shuffledCrew.get(index);
        Crew crewTwo = shuffledCrew.get(index + 1);
        Pair pair = new Pair(pairTag.getLevel());
        pair.addCrew(crewOne);
        pair.addCrew(crewTwo);
        result.add(pair);
    }

    private List<Crew> mapNamesToCrews(List<String> names, Course course) {
        List<String> shuffledNames = Randoms.shuffle(names);
        return shuffledNames.stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList());
    }


    private boolean isDuplicatePair(List<Pair> pairs, PairTag pairTag) {
        List<Pair> registeredPairs = PairRepository.getPairsIn(pairTag.getCourse(), pairTag.getLevel());
        for (Pair pair : pairs) {
            if (isAlreadyPairedInSameLevel(registeredPairs, pair)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAlreadyPairedInSameLevel(List<Pair> pairs, Pair testPair) {
        List<Crew> crews = testPair.getCrews();
        for (Pair pair : pairs) {
            if (pair.hasCrew(crews.get(FIRST_CREW_INDEX)) && pair.hasCrew(crews.get(SECOND_CREW_INDEX))) {
                return true;
            }
        }
        if (testPair.hasThreeCrewMembers()) {
            return isAlreadyPairedInSameLevel(pairs, crews);
        }
        return false;
    }

    // 한 페어의 크루원이 3명인 경우
    private boolean isAlreadyPairedInSameLevel(List<Pair> pairs, List<Crew> crews) {
        for (Pair pair : pairs) {
            if (pair.hasCrew(crews.get(FIRST_CREW_INDEX)) && pair.hasCrew(crews.get(THIRD_CREW_INDEX))) {
                return true;
            }
            if (pair.hasCrew(crews.get(SECOND_CREW_INDEX)) && pair.hasCrew(crews.get(THIRD_CREW_INDEX))) {
                return true;
            }
        }
        return false;
    }



    public boolean isRegistered(PairTag pairTag) {
        return PairRepository.hasPairs(pairTag);
    }

    public void clear() {
        PairRepository.clear();
    }

    public List<Pair> getPairs(PairTag pairTag) {
        return PairRepository.get(pairTag);
    }
}
