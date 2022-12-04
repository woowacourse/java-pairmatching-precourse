package pairmatching.controller;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.Crew;
import pairmatching.model.Pair;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.system.util.PairsMaker;
import pairmatching.vo.PairMatchingInfo;

import java.util.List;
import java.util.Map;

public class MatchingPairController implements Controller {
    public static final String CREW_MATCHING_FAILED_THREE_TIMES_MESSAGE = "크루 매칭이 3회 이상 실패하였습니다.";
    private final CrewRepository crewRepository;
    private final PairMatchingRepository pairMatchingRepository;
    private final PairsMaker pairsMaker;

    public MatchingPairController(CrewRepository crewRepository, PairMatchingRepository pairMatchingRepository, PairsMaker pairsMaker) {
        this.crewRepository = crewRepository;
        this.pairMatchingRepository = pairMatchingRepository;
        this.pairsMaker = pairsMaker;
    }

    @Override
    public void process(Map<String, Object> model) {
        PairMatchingInfo pairMatchingInfo = (PairMatchingInfo) model.get("pairMatchingInfo");
        List<Crew> crews = crewRepository.findByCourse(pairMatchingInfo.getCourse());
        List<Pair> pairs;

        int notMatchedCount = 0;
        do {
            pairs = pairsMaker.makePairs(getShuffledCrews(crews));
            notMatchedCount++;
            if (notMatchedCount == 3) {
                throw new IllegalStateException(CREW_MATCHING_FAILED_THREE_TIMES_MESSAGE);
            }
        } while (pairMatchingRepository.hasDuplicatingAtSameLevel(pairMatchingInfo, pairs));

        pairMatchingRepository.save(pairMatchingInfo, pairs);
    }

    private List<Crew> getShuffledCrews(List<Crew> crews) {
        return Randoms.shuffle(crews);
    }
}
