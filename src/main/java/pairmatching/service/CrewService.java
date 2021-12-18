package pairmatching.service;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Crews;
import pairmatching.util.Reader;

import java.util.List;
import java.util.stream.Collectors;

public class CrewService {
    private Crews backendCrews;
    private Crews frontendCrews;

    public List<Crew> getCrews(String course) {
        if (course.equals(Course.BACKEND.getName())) {
            return backendCrews.getCrews();
        }
        if (course.equals(Course.FRONTEND.getName())) {
            return frontendCrews.getCrews();
        }
        return null;
    }

    public List<String> getCrewNames(String course) {
        if (course.equals(Course.BACKEND.getName())) {
            return backendCrews.getCrewNames();
        }
        if (course.equals(Course.FRONTEND.getName())) {
            return frontendCrews.getCrewNames();
        }
        return null;
    }

    public void initCrewsByReader() {
        List<Crew> backend = Reader.readCrewName(Reader.backendCrew).stream()
                .map(crew -> Crew.from(Course.BACKEND, crew))
                .collect(Collectors.toList());
        List<Crew> frontend = Reader.readCrewName(Reader.frontendCrew).stream()
                .map(crew -> Crew.from(Course.FRONTEND, crew))
                .collect(Collectors.toList());

        backendCrews = Crews.from(backend);
        frontendCrews = Crews.from(frontend);
    }
}
