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
        List<Pair> pairs = pairsMaker.makePairs(getShuffledCrews(crews));
        pairMatchingRepository.save(pairMatchingInfo, pairs);
    }

    private List<Crew> getShuffledCrews(List<Crew> crews) {
        return Randoms.shuffle(crews);
    }
}
