package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Pair {
    Course course;
    String mission;
    List<String> crewNames;

    public Pair(Course course, String mission) throws IOException {
        this.course = course;
        this.mission = mission;

        shuffledCrew();
    }

    private void shuffledCrew() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(course.getFileName()));
        crewNames = new ArrayList<>();
        String line;
        while((line = br.readLine())!=null) crewNames.add(line);
        br.close();

        crewNames = Randoms.shuffle(crewNames);
    }

}
