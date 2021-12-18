package pairmatching.domain;

import java.util.List;

public class PairMatchingMachine {
    private final RandomPairMatchingGenerator randomPairMatchingGenerator;

    public PairMatchingMachine(RandomPairMatchingGenerator randomPairMatchingGenerator) {
        this.randomPairMatchingGenerator = randomPairMatchingGenerator;
    }

    public PairInformation share(PairMission pairMission, List<Crew> crews) {
        return randomPairMatchingGenerator.generate(pairMission, crews);
    }
}