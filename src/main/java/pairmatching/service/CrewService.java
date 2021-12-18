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

    public List<String> getBackendCrewsName() {
        return backendCrews.getCrewsName();
    }

    public List<String> getFrontendCrewsName() {
        return frontendCrews.getCrewsName();
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
