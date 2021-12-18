package pairmatching.crew.backend;

import pairmatching.crew.Course;
import pairmatching.crew.CourseCrewService;
import pairmatching.crew.Crew;
import pairmatching.exception.NotFoundException;
import pairmatching.utils.message.ErrorMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BackEndCrewService implements CourseCrewService {

    private final BackEndCrewRepository backEndCrewRepository;

    private BackEndCrewService() {
        backEndCrewRepository = BackEndCrewRepository.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final BackEndCrewService instance = new BackEndCrewService();
    }

    public static BackEndCrewService getInstance() {
        return InnerInstanceClazz.instance;
    }

    @Override
    public void initialCrew(String crewFilePath) {
        List<String> names = getAllCrewName(crewFilePath);
        for(String name : names) {
            backEndCrewRepository.add(Crew.fromCourseAndName(Course.BACKEND, name));
        }
    }

    private List<String> getAllCrewName(String crewFilePath) {
        try {
            return Files.readAllLines(Paths.get(crewFilePath));
        }catch(IOException e) {
            throw new NotFoundException(ErrorMessage.NOT_EXIST_FILE_PATH);
        }
    }
}
