package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return course == pair.course && Objects.equals(mission, pair.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission);
    }
}
