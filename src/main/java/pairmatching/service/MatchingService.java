package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Mission;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.system.exception.PairMatchingAlreadyExistException;
import pairmatching.vo.PairMatchingInfo;

import java.util.List;

public class MatchingService {

    public static final String PAIR_MATCHING_NOT_EXISTING = "매칭 이력이 없습니다.";
    public static final String NOT_ENOUGH_CREWS = "페어 매칭이 가능한 경우의 수가 없습니다.";

    public static void doMatch(Course course, Mission mission) {
        List<String> crewNames = CrewRepository.findAllByCourse(course);
        if (crewNames.size() < 2) {
            throw new IllegalStateException(NOT_ENOUGH_CREWS);
        }
        List<String> shuffledCrewNames = Randoms.shuffle(crewNames);
        PairMatchingInfo pairMatchingInfo = PairMatchingInfo.of(course, mission);
        PairMatchingRepository.save(pairMatchingInfo, shuffledCrewNames);
    }

    public static void checkPairMatchingAlreadyExists(Course course, Mission mission) {
        if (PairMatchingRepository.existingWith(course, mission)) {
            throw new PairMatchingAlreadyExistException();
        }
    }

    public static List<List<String>> findAllPairs(Course course, Mission mission) {
        PairMatchingInfo pairMatchingInfo = PairMatchingInfo.of(course, mission);
        List<List<String>> pairs = PairMatchingRepository.findAllPairsBy(pairMatchingInfo);
        if (pairs == null) {
            throw new IllegalArgumentException(PAIR_MATCHING_NOT_EXISTING);
        }
        return pairs;
    }

    public static void resetPairMatching(Course course, Mission mission) {
        PairMatchingInfo pairMatchingInfo = PairMatchingInfo.of(course, mission);
        PairMatchingRepository.reset(pairMatchingInfo);
    }
}
