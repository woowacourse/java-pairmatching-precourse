package pairmatching.model;

import java.util.HashMap;

public class Mission {
    private String name;
    private HashMap<Course, PairList> pairMap = new HashMap<>();

    public Mission(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPairMap(Course course, PairList pairList){
        pairMap.put(course, pairList);
    }

    public PairList getPairList(Course course){
        return pairMap.get(course);
    }
}
