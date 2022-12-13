package pairmatching.domain;

import pairmatching.util.CrewReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {
    private static final String NO_CREW_NAME_ERROR = "[ERROR] 해당하는 과정 내 크루의 이름이 없습니다.";

    private final List<Crew> crews = new ArrayList<>();

    public Crews(){
        for(Course course : Course.values()){
            addCrews(course);
        }
    }

    private void addCrews(Course course){
        List<String> namesInCourse = CrewReader.readCrewMembers(course);
        crews.addAll(namesToCrews(course, namesInCourse));
    }

    private List<Crew> namesToCrews(Course course, List<String> names){
        return names.stream()
                .map(name->new Crew(course, name))
                .collect(Collectors.toList());
    }

    public Crew findCrew(Course course, String name){
        return crews.stream()
                .filter(crew->crew.isInCourse(course))
                .filter(crew->crew.isCrewName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_CREW_NAME_ERROR));
    }

    public List<String> getNamesByCourse(Course course){
        return crews.stream()
                .filter(crew->crew.isInCourse(course))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
