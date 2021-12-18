package pairmatching.domain.crew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.course.enums.CourseEnum;

public class Crews {
    private Map<CourseEnum, List<Crew>> crews = new HashMap<>();

    public void add(CourseEnum backend, List<Crew> crewList) {
        this.crews.put(backend, crewList);
    }
}
