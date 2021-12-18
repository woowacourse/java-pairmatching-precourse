package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PairManager {

    public List<Crew> registerCrews() {
        List<Crew> crews = new ArrayList<>();
        try {
            BufferedReader rawBackendCrewNames = new BufferedReader(new FileReader("src/main/resources/backend-crew.md"));
            BufferedReader rawFrontendCrewNames = new BufferedReader(new FileReader("src/main/resources/frontend-crew.md"));
            addCrew(rawBackendCrewNames, crews, Course.BACKEND);
            addCrew(rawFrontendCrewNames, crews, Course.FRONTEND);
        } catch (IOException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
        return crews;
    }

    private void addCrew(BufferedReader br, List<Crew> crews, Course course) throws IOException {
        while (true) {
            String crewName = br.readLine();
            if (crewName == null) {
                break;
            }
            Crew newCrew = new Crew(course, crewName);
            crews.add(newCrew);
        }
    }
}
