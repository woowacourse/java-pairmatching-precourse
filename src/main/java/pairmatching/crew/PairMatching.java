package pairmatching.crew;

import pairmatching.Course;
import pairmatching.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMatching {
    static List<List<String>> pairCrew = new ArrayList<>();
    static LoadFile file = new LoadFile();

    public static void pairMatch(Course course, Level level, String mission) {
        int count = 0;
        while (true) {
            List<String> crew = file.getCrew(course);
            if (PairMatching.isPairedCrew(level, crew)) {
                pairCrew = PairMatching.getPairCrew();
                return;
            }
            if (count == 3) {
                throw new IllegalArgumentException();
            }
            count += 1;
        }
    }

    public static boolean isPairedCrew(Level level, List<String> crew) {
        if (isOdd(crew)) {
            return matchOdd(level, crew);
        }
        return matchEven(level, crew);
    }

    public static List<List<String>> getPairCrew() {
        return pairCrew;
    }

    public static boolean isOdd(List<String> crew) {
        if (crew.size() % 2 == 0) {
            return false;   // 짝수
        }
        return true;
    }

    public static boolean matchOdd(Level level, List<String> crew) {
        List<String> crews = crew;
        while (crews.size() != 1) {
            List<String> pair = Arrays.asList(crews.get(0), crews.get(1));
            if (CrewRepository.checkDuplicated(level, pair)) {
                return false;
            }
            pairCrew.add(pair);
            crews.remove(0);
            crews.remove(1);
        }
        pairCrew.get(-1).add(crews.get(0));
        CrewRepository.savePair(level, pairCrew);
        return true;
    }

    public static boolean matchEven(Level level, List<String> crew) {
        List<String> crews = crew;
        while (crews.size() != 0) {
            List<String> pair = Arrays.asList(crews.get(0), crews.get(1));
            if (CrewRepository.checkDuplicated(level, pair)) {
                return false;
            }
            pairCrew.add(pair);
            crews.remove(0);
            crews.remove(1);
        }
        CrewRepository.savePair(level, pairCrew);
        return true;
    }


}
