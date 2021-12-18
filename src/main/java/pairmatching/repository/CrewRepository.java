package pairmatching.repository;

import pairmatching.domain.Crew;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private static final List<Crew> crews = new ArrayList<>();


    public static void addCrew(Crew crew){
        crews.add(crew);
    }
}
