package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crew {
    private List<CrewList> crewList;

    public Crew(List<pairmatching.model.CrewList> crewList) {
        this.crewList = crewList;
    }

    public Map<String, String> makeRandomPair(List<String> crewList) {
        CrewList crewList1 = new CrewList(crewList, crewList);

        List<String> randomBackEndCrew = Randoms.shuffle(crewList1.getBackEndCrewList());
        List<String> randomFrontEndCrew = Randoms.shuffle(crewList1.getFrontEndCrewList());

        Map<String, String> randomPairList = new HashMap<>();
        for (int i = 0; i < randomBackEndCrew.size(); i++) {
            randomPairList.put(randomBackEndCrew.get(i), randomFrontEndCrew.get(i));
        }

        return randomPairList;
    }
}
