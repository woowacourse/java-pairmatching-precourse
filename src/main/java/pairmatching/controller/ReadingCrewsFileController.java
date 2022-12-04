package pairmatching.controller;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.repository.CrewRepository;
import pairmatching.system.convertion.NamesToCrewConverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadingCrewsFileController implements Controller {

    public static final String BACKEND_CREWS_FILE_DIRECTORY = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREWS_FILE_DIRECTORY = "src/main/resources/frontend-crew.md";

    private final CrewRepository crewRepository;

    public ReadingCrewsFileController(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    @Override
    public void process(Map<String, Object> model) {
        try {
            List<Crew> backEndCrews = NamesToCrewConverter.convert(readBackEndCrews(), Course.BACKEND);
            crewRepository.saveAll(backEndCrews);

            List<Crew> frontEndCrews = NamesToCrewConverter.convert(readFrontEndCrews(), Course.FRONTEND);
            crewRepository.saveAll(frontEndCrews);
        } catch (IOException e) {
            throw new IllegalStateException("크루 파일 읽기에 문제가 발생했습니다.");
        }
    }

    private static List<String> readBackEndCrews() throws IOException {
        List<String> crewNames = new ArrayList<>();
        readFile(crewNames, BACKEND_CREWS_FILE_DIRECTORY);
        return crewNames;
    }

    private static List<String> readFrontEndCrews() throws IOException {
        List<String> crewNames = new ArrayList<>();
        readFile(crewNames, FRONTEND_CREWS_FILE_DIRECTORY);
        return crewNames;
    }

    private static void readFile(List<String> crewNames, String fileDirectory) throws IOException {
        File file = new File(fileDirectory);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        readLine(crewNames, bufferedReader);
        bufferedReader.close();
    }

    private static void readLine(List<String> crewNames, BufferedReader bufferedReader) throws IOException {
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            crewNames.add(line);
        }
    }
}
