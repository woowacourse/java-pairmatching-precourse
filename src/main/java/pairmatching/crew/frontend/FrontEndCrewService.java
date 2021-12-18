package pairmatching.crew.frontend;

import pairmatching.crew.Course;
import pairmatching.crew.CourseCrewService;
import pairmatching.crew.Crew;
import pairmatching.exception.NotFoundException;
import pairmatching.utils.message.ErrorMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FrontEndCrewService implements CourseCrewService {

    private final FrontEndCrewRepository frontEndCrewRepository;

    private FrontEndCrewService() {
        frontEndCrewRepository = FrontEndCrewRepository.getInstance();
    }

    private static class InnerInstanceClazz {
        private static final FrontEndCrewService instance = new FrontEndCrewService();
    }

    public static FrontEndCrewService getInstance() {
        return InnerInstanceClazz.instance;
    }

    @Override
    public void initialCrew(String crewFilePath) {
        List<String> names = getAllCrewName(crewFilePath);
        for(String name : names) {
            frontEndCrewRepository.add(Crew.fromCourseAndName(Course.FRONTEND, name));
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
