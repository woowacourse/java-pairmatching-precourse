package pairmatching.repository;

import pairmatching.domain.Crew;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
    private static final List<Crew> crews = new ArrayList<>();

    public static List<String> allCrewByName(){
        return crews.stream()
                .map(crew -> crew.getName())
                .collect(Collectors.toList());
    }

    public static void addCrew(Crew crew){
        crews.add(crew);
    }

    public static Crew findByName(String name){
        return crews.stream()
                .filter(crew -> crew.isEqual(name))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 멤버입니다."));
    }
}
