package pairmatching.domain;

import java.util.List;

public class PairMatchingMachine {
    private final RandomPairMatchingGenerator randomPairMatchingGenerator;
    private final List<PairInformation> pairInformations;

    public PairMatchingMachine(RandomPairMatchingGenerator randomPairMatchingGenerator,
        List<PairInformation> pairInformations) {
        this.randomPairMatchingGenerator = randomPairMatchingGenerator;
        this.pairInformations = pairInformations;
    }

    public PairInformation share(PairMission pairMission, List<Crew> crews) {
        return randomPairMatchingGenerator.generate(pairMission, crews);
    }

    public boolean isPairMission(PairMission pairMission) {
        return pairInformations.stream()
            .anyMatch(pairInformation -> pairInformation.isSamePairMission(pairMission));
    }

    public void addPairInformation(PairInformation pairInformation) {
        this.pairInformations.add(pairInformation);
    }

    public PairInformation findPairInformation(PairMission pairMission) {
        return pairInformations.stream()
            .filter(pairInformation -> pairInformation.isSamePairMission(pairMission))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 등록된 매칭이 없습니다."));
    }
}