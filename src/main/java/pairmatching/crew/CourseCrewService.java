package pairmatching.crew;

import java.util.List;

public interface CourseCrewService {

    void initialCrew(String crewFilePath);

    List<Crew> findAll();
}
