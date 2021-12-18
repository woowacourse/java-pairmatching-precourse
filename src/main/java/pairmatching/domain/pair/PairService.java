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

        List<Pair> result = null;
        int count = 0;

        do {
            List<Pair> pairs = matchPairs(pairTag);
            if (!isDuplicatePair(pairs, pairTag)) {
                result = pairs;
                break;
            }
            count++;
        } while (count < 3);

        if (result == null) {
            throw new IllegalArgumentException("[ERROR] 이미 페어가 존재하거나 매칭을 할 수 없습니다.");
        }

        PairRepository.save(pairTag, result);
        return result;
    }

    private List<Pair> matchPairs(PairTag pairTag) {
        List<Pair> result = new ArrayList<>();
        List<Crew> shuffledCrew = null;
        if (pairTag.getCourse() == Course.BACKEND) {
            shuffledCrew = mapNamesToCrews(backend, Course.BACKEND);
        }
        if (pairTag.getCourse() == Course.FRONTEND) {
            shuffledCrew = mapNamesToCrews(frontend, Course.FRONTEND);
        }

        int i = 0;
        while (i < shuffledCrew.size() - 1) {
            Crew crewOne = shuffledCrew.get(i);
            Crew crewTwo = shuffledCrew.get(i + 1);
            Pair pair = new Pair(pairTag.getLevel());
            pair.addCrew(crewOne);
            pair.addCrew(crewTwo);
            result.add(pair);
            i += 2;
        }
        if (shuffledCrew.size() % 2 != 0) {
            Pair pair = result.get(result.size() - 1);
            pair.addCrew(shuffledCrew.get(shuffledCrew.size() - 1));
        }

        return result;
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
