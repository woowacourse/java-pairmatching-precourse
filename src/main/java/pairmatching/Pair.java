package pairmatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pair {

    private Map<String, Crew> pairMemberMap= new HashMap<>();

    public void addMember(Crew crew) {
        pairMemberMap.put(crew.getName(), crew);
    }

    public Crew findMember(String name) {
        return pairMemberMap.get(name);
    }

    public boolean isPair(String name1, String name2) {
        return pairMemberMap.containsKey(name1) && pairMemberMap.containsKey(name2);
    }
}
