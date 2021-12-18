package pairmatching;

import java.util.List;

import pairmatching.controller.FileInputController;
import pairmatching.domain.Course;
import pairmatching.repository.CrewMembers;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        initApplication();
    }

    private static void initApplication() {
        FileInputController.setCrewMembers();
        List<String> crewsByCourse = CrewMembers.getCrewsByCourse(Course.BACKEND);
        for(String name:crewsByCourse){
            System.out.println("name = " + name);
        }
    }
}
