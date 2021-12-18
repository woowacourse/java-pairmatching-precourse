package pairmatching.matching;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.crew.Crew;
import pairmatching.crew.Level;

import java.util.ArrayList;
import java.util.List;

public interface CourseMatchingService {

    void saveMatchingTitle(Level level, String mission);

    void savePair(List<Pair> pairs);

    default List<Pair> createPair(List<Crew> crews, Level level, String mission) {
        List<Crew> shuffledCrew = Randoms.shuffle(crews);
        int crewCount = (shuffledCrew.size() + 1) / 2;

        List<Pair> pairResult = new ArrayList<>();
        for(int i = 0; i < crewCount; i += 2) {
            String firstCrewName = shuffledCrew.get(i).getName();
            String secondCrewName = shuffledCrew.get(i + 1).getName();
            Pair newPair = Pair.fromTwoCrewName(level, mission, firstCrewName, secondCrewName);

            if(crewCount - 1 == i + 2) {
                String thirdCrewName = shuffledCrew.get(i + 2).getName();
                newPair.addThirdCrew(thirdCrewName);
            }
            pairResult.add(newPair);
        }
        return pairResult;
    }

    default boolean isExistSameLevelPair(List<Pair> sameLevelPair, Pair comparePair) {
        for(Pair standardPair : sameLevelPair) {
            if(standardPair.isExistPair(comparePair)) {
                return true;
            }
        }
        return false;
    }
}
