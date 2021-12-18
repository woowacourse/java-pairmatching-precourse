package pairmatching.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPairMatchingGenerator {

    public PairInformation generate(PairMission pairMission, List<Crew> crews) {
        LinkedList<Crew> shuffle = new LinkedList<>(Randoms.shuffle(crews));
        List<Pair> pairs = getPairs(shuffle);

        return new PairInformation(pairMission, pairs);
    }

    private List<Pair> getPairs(LinkedList<Crew> shuffle) {
        List<Pair> pairs = new ArrayList<>();
        while (shuffle.size() != 0) {
            List<Crew> pairCrew = new ArrayList<>();
            pairCrew.add(shuffle.pollFirst());
            pairCrew.add(shuffle.pollFirst());

            if (shuffle.size() == 1) {
                pairCrew.add(shuffle.pollFirst());
            }

            pairs.add(new Pair(pairCrew));
        }
        return pairs;
    }
}