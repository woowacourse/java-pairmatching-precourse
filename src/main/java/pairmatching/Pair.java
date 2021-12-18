package pairmatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pair {

    private Map<String, Crew> pairMemberMap= new HashMap<>();

    public void addMember(Crew crew) {
        pairMemberMap.put(crew.getName(), crew);
    }

    public Crew findMember(String name) {
        return pairMemberMap.get(name);
    }

    public Pair(){};

    public List<String> getPairMemberNameList() {
        return pairMemberMap.values().stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    public void addCrew(Crew crew) {
        pairMemberMap.put(crew.getName(), crew);
    }

    public boolean isPair(String name1, String name2) {
        return pairMemberMap.containsKey(name1) && pairMemberMap.containsKey(name2);
    }
}
