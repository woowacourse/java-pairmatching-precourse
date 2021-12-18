package pairmatching.crew;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CrewShuffle {
    public static List<String> getRandomCrews(List<String> crew) {
        List<String> shuffledCrew = Randoms.shuffle(crew);
        return shuffledCrew;
    }
}
