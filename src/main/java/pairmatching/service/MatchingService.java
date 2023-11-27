package pairmatching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pairmatching.domain.entity.CourseMission;
import pairmatching.domain.entity.MatchingResult;
import pairmatching.domain.entity.Pair;
import pairmatching.repository.MatchingResultRepository;
import pairmatching.util.MathUtil;
import pairmatching.util.RandonUtil;

public class MatchingService {

    private final MatchingResultRepository matchingResultRepository;

    public MatchingService(MatchingResultRepository matchingResultRepository) {
        this.matchingResultRepository = matchingResultRepository;
    }

    public MatchingResult createMatchingResult(List<String> crews) {
        List<String> shuffledCrews = RandonUtil.shuffle(crews);
        List<Pair> pairs = new ArrayList<>();
        final int crewSize = crews.size();
        final int pairSize = crewSize / 2;

        for (int pairStartIndex = 0; pairStartIndex < pairSize; pairStartIndex++) {
            pairs.add(createPair(shuffledCrews, pairStartIndex));
        }

        if (MathUtil.isOddNumber(crewSize)) {
            String lastCrew = crews.get(crewSize-1);
            pairs.get(pairSize-1).addCrew(lastCrew);
        }

        return MatchingResult.create(pairs);
    }


    public Optional<MatchingResult> findMatchingResult(CourseMission courseMission) {
        return matchingResultRepository.findBySameObject(courseMission);
    }

    public void resetMatching() {
        matchingResultRepository.deleteAll();
    }

    public void save(CourseMission courseMission, MatchingResult matchingResult) {
        matchingResultRepository.save(courseMission, matchingResult);
    }

    private Pair createPair(final List<String> shuffledCrews,final int index) {
        List<String> pairMembers = new ArrayList<>();
        pairMembers.add(shuffledCrews.get(index));
        pairMembers.add(shuffledCrews.get(index + 1));

        return Pair.create(pairMembers);
    }

}

