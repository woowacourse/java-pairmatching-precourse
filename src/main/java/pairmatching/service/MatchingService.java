package pairmatching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import pairmatching.domain.entity.CourseMission;
import pairmatching.domain.entity.MatchingResult;
import pairmatching.domain.entity.Mission;
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
        final List<String> shuffledCrews = RandonUtil.shuffle(crews);
        final List<Pair> pairs = new ArrayList<>();
        final int crewSize = shuffledCrews.size();
        final int pairSize = crewSize / 2;

        for (int pairStartIndex = 0; pairStartIndex < crewSize; pairStartIndex += 2) {
            pairs.add(createPair(shuffledCrews, pairStartIndex));
        }

        processLastCrew(crewSize, shuffledCrews, pairs, pairSize);
        return MatchingResult.create(pairs);
    }

    private static void processLastCrew(int crewSize, List<String> shuffledCrews, List<Pair> pairs, int pairSize) {
        if (MathUtil.isOddNumber(crewSize)) {
            String lastCrew = shuffledCrews.get(crewSize - 1);
            pairs.get(pairSize - 1).addCrew(lastCrew);
        }
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

    public boolean isDuplicatedPair(CourseMission courseMission, MatchingResult matchingResult) {
        List<Mission> missions = courseMission.getLevel().getMissions();
        List<Pair> pairs = matchingResult.getPairs();

        return missions.stream()
                .allMatch(mission -> {
                    Optional<MatchingResult> foundMatchingResult
                            = matchingResultRepository.findByMission(mission);

                    if (!foundMatchingResult.isPresent()) {
                        return false;
                    }

                    List<Pair> foundPairs = foundMatchingResult.get().getPairs();
                    return foundPairs.stream()
                            .allMatch(pair -> pairs.contains(pair));
                });
    }

    private Pair createPair(final List<String> shuffledCrews, final int index) {
        List<String> pairMembers = new ArrayList<>();
        pairMembers.add(shuffledCrews.get(index));
        pairMembers.add(shuffledCrews.get(index + 1));

        return Pair.create(pairMembers);
    }

}

