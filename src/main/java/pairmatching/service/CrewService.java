package pairmatching.service;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class CrewService {

    public List<Crew> createCrewList(Course course) {
        List<Crew> crewList = new ArrayList<>();

        String courseName = course.name().toLowerCase();

        List<String> crewNameList = readCrewFromFile(courseName);

        shuffle(crewNameList);

        for (String crewName : crewNameList) {
            Crew crew = new Crew(course, crewName);

            crewList.add(crew);
        }

        return crewList;
    }

    private List<String> readCrewFromFile(String courseName) {

        List<String> crewNameList = new ArrayList<>();

        String filename = courseName + "-crew.md";

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(readFilePath(filename)))) {
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                crewNameList.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("[ERROR] 파일을 읽지 못하였습니다.");
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 파일을 읽지 못하였습니다.");
        }

        return crewNameList;
    }

    private static String readFilePath(String filename) {
        ClassLoader classLoader = CrewService.class.getClassLoader();
        String path = classLoader.getResource(filename).getPath();
        return path;
    }
}
