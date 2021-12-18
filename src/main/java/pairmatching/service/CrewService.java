package pairmatching.service;
import pairmatching.domain.Crew;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;
import static pairmatching.domain.Course.BACKEND;
import static pairmatching.domain.Course.FRONTEND;

public class CrewService {

    public List<Crew> createBackCrewList() {
        List<Crew> backCrewList = new ArrayList<>();

        List<String> backCrewName = readBackCrewFromFile();

        shuffle(backCrewName);

        for (String crewName : backCrewName) {
            Crew crew = new Crew(BACKEND, crewName);

            backCrewList.add(crew);
        }

        return backCrewList;
    }

    public List<Crew> createFrontCrewList() {
        List<Crew> frontCrewList = new ArrayList<>();

        List<String> frontCrewName = readFrontCrewFromFile();

        shuffle(frontCrewName);

        for (String crewName : frontCrewName) {
            Crew crew = new Crew(FRONTEND, crewName);

            frontCrewList.add(crew);
        }

        return frontCrewList;
    }

    private List<String> readBackCrewFromFile() {

        List<String> crewNameList = new ArrayList<>();

        try {
            File file = new File("../../resources/backend-crew.md");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                crewNameList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("[ERROR] 파일을 읽지 못하였습니다.");
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 파일을 읽지 못하였습니다.");
        }

        return crewNameList;
    }

    private List<String> readFrontCrewFromFile() {

        List<String> crewNameList = new ArrayList<>();

        try {
            File file = new File("../../resources/frontend-crew.md");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                crewNameList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("[ERROR] 파일을 읽지 못하였습니다.");
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 파일을 읽지 못하였습니다.");
        }

        return crewNameList;
    }
}
