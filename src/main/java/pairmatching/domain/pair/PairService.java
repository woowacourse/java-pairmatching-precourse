package pairmatching.domain.pair;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairService {

    private final List<String> frontend;
    private final List<String> backend;

    public PairService(List<String> frontend, List<String> backend) {
        this.frontend = frontend;
        this.backend = backend;
    }

    public List<Pair> makePairs(PairTag pairTag) {
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
        List<String> shuffledNames = Randoms.shuffle(backend);
        List<Crew> shuffledCrew = null;
        if (pairTag.getCourse() == Course.BACKEND) {
            shuffledCrew = shuffledNames.stream()
                    .map(name -> new Crew(Course.BACKEND, name))
                    .collect(Collectors.toList());
        }
        if (pairTag.getCourse() == Course.FRONTEND) {
            shuffledCrew = shuffledNames.stream()
                    .map(name -> new Crew(Course.FRONTEND, name))
                    .collect(Collectors.toList());
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


    private boolean isDuplicatePair(List<Pair> pairs, PairTag pairTag) {

        List<Pair> registeredPairInSameLevel = PairRepository.getPairsIn(pairTag.getCourse(), pairTag.getLevel());
        // TODO: 2021/12/18 한 페어에 세명의 크루가 존재할 경우 분기처리
        for (Pair pair : pairs) {
            if (isAlreadyPairedInSameLevel(registeredPairInSameLevel, pair)) {
                return true;
            }
        }

        return false;
    }

    private boolean isAlreadyPairedInSameLevel(List<Pair> pairs, Pair testPair) {
        List<Crew> crews = testPair.getCrews();
        for (Pair pair : pairs) {
            if (pair.hasCrew(crews.get(0)) && pair.hasCrew(crews.get(1))) {
                return true;
            }
        }
        return false;
    }


}
