package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Crew {
    private Course course;
    private String name;

    public Crew(Course course, String name){
        this.course = course;
        this.name = name;
    }

    public Course getCourse(){
        return this.course;
    }

    public String getName(){
        return this.name;
    }

}
