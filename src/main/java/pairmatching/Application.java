package pairmatching;

import java.util.List;
import java.util.stream.Stream;

import userInterafce.PairMatch;

public class Application {
    public static void main(String[] args) {
        PairMatch pair = new PairMatch();
        //pair.run();

        List<String> crewList = pair.getShuffledCrewList(Course.FRONTEND);
        Stream stream = Stream.of(crewList);
        stream.forEach(System.out::println);
    }
}
