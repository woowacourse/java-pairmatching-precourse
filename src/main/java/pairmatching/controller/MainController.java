package pairmatching.controller;

import java.util.List;
import pairmatching.Setup;
import pairmatching.domain.CrewRepository;
import pairmatching.domain.PairMemory;
import pairmatching.domain.PairMemoryRepository;
import pairmatching.domain.Section;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class MainController {
    private Setup setup;
    private PairMemoryRepository pairMemoryRepository;

    public MainController() {
        setup = new Setup();
        pairMemoryRepository = new PairMemoryRepository();
    }

    public void start() {
//        List<List<String>> backends1 = CrewRepository.makeBackendPair();
//        System.out.println("backend1 그룹 개수 : " + backends1.size());
//        Section section = new Section(Course.BACKEND, Level.LEVEL1, "경주게임");
//        pairMemoryRepository.addPairMemory(new PairMemory(section, backends1));
//        List<List<String>> backends2 = CrewRepository.makeBackendPair();
//        System.out.println("backend2 그룹 개수 : " + backends2.size());
//        pairMemoryRepository.validatePairMemory(new PairMemory(section, backends2));
    }
}
