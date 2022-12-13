package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Crew {
    private final Course course;
    private final String name;
    private final HashMap<Level, List<String>> pairNames = new HashMap<>();


    public Crew(Course course, String name){
        this.course = course;
        this.name = name;
        initPairNames();
    }

    private void initPairNames(){
        for(Level level : Level.values()){
            pairNames.put(level, new ArrayList<>());
        }
    }

    public boolean isInCourse(Course course){
        return this.course.equals(course);
    }

    public boolean isCrewName(String name){
        return this.name.equals(name);
    }

    public boolean hasPairedAtLeastOnceInLevel(Level level, String name){
        return pairNames.get(level).contains(name);
    }

    public void addPairName(Level level, String name){
        pairNames.get(level).add(name);
    }

    public String getName(){
        return name;
    }
}
