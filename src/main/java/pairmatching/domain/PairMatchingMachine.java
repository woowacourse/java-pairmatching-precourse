package pairmatching.domain;

import java.util.List;

public class PairMatchingMachine {
    private final RandomPairMatchingGenerator randomPairMatchingGenerator;
    private final List<PairMission> pairMissions;

    public PairMatchingMachine(RandomPairMatchingGenerator randomPairMatchingGenerator,
        List<PairMission> pairMissions) {
        this.randomPairMatchingGenerator = randomPairMatchingGenerator;
        this.pairMissions = pairMissions;
    }

    public PairInformation share(PairMission pairMission, List<Crew> crews) {
        return randomPairMatchingGenerator.generate(pairMission, crews);
    }

    public boolean isPairMission(PairMission pairMission) {
        return pairMissions.contains(pairMission);
    }

    public void addPairMission(PairMission pairMission) {
        this.pairMissions.add(pairMission);
    }
}