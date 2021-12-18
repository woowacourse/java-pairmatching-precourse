package pairmatching.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

public class PairMatchingMachine {
    private final RandomPairMatchingGenerator randomPairMatchingGenerator;
    private List<PairInformation> pairInformations;

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

    public boolean isDuplicateCrew(PairInformation addPairInformation) {
        List<PairInformation> sameLevelPairInformations = pairInformations.stream()
            .filter(pairInformation ->
                pairInformation.getPairMission().isSameLevel(addPairInformation.getPairMission()))
            .collect(toList());

        return sameLevelPairInformations.stream()
            .anyMatch(pairInformation -> pairInformation.isSamePair(addPairInformation));
    }

    public void addPairInformation(PairInformation addPairInformation) {
        this.pairInformations.add(addPairInformation);
    }

    public PairInformation findPairInformation(PairMission pairMission) {
        return pairInformations.stream()
            .filter(pairInformation -> pairInformation.isSamePairMission(pairMission))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 등록된 매칭이 없습니다."));
    }

    public void removePairInformations() {
        this.pairInformations = new ArrayList<>();
    }
}