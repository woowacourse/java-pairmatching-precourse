package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.repository.CrewRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class SetupCrewController extends AbstractController {

    public static final String FILE_NOT_FOUND_MESSAGE = "파일을 읽어오지 못했습니다.";
    public static final String BACKEND_CREW_MD = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_MD = "src/main/resources/frontend-crew.md";

    @Override
    public void doProcess(Map<String, Object> model) {
        saveCrewsFromFile(BACKEND_CREW_MD, Course.BACKEND);
        saveCrewsFromFile(FRONTEND_CREW_MD, Course.FRONTEND);
    }

    private static void saveCrewsFromFile(String crewFilePath, Course course) {
        try {
            Scanner scanner = new Scanner(new File(crewFilePath));
            while (scanner.hasNext()) {
                String crewName = scanner.nextLine();
                CrewRepository.save(course, crewName);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(FILE_NOT_FOUND_MESSAGE);
        }
    }
}
