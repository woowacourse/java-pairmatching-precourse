package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Pair {
    Course course;
    Mission mission;
    List<String> crewNames;
    HashMap<String, String[]> alreadyMatched;

    public Pair(Course course, Mission mission) throws IOException {
        this.course = course;
        this.mission = mission;

        shuffledCrew();
        insertMatchedMap();
    }

    private void shuffledCrew() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(course.getFileName()));
        crewNames = new ArrayList<>();
        String line;
        while((line = br.readLine())!=null) crewNames.add(line);
        br.close();

        crewNames = Randoms.shuffle(crewNames);
    }

    private void insertMatchedMap() {
        int totalSize = calculateTotalSize();

        for (int crewNumber = 0; crewNumber < totalSize;) {
            // TODO: 중복 검사
            alreadyMatched.put(crewNames.get(crewNumber), new String[] {crewNames.get(crewNumber+1)});
            alreadyMatched.put(crewNames.get(crewNumber+1), new String[] {crewNames.get(crewNumber)});
            crewNumber = crewNumber + 2;
        }
        insertRestCrew(totalSize);
    }

    public int calculateTotalSize() {
        if (crewNames.size() % 2 != 0) return crewNames.size() - 3;
        return crewNames.size();
    }

    private void insertRestCrew(int total) {
        if (total ==  crewNames.size()) return;
        int[] right = {1, -1, -2};
        int[] left = {2, 1, -1};

        for (int index = 0; index < 3; index++) {
            alreadyMatched.put(crewNames.get(crewNames.size()-3+index),
                    new String[] {crewNames.get(crewNames.size()-3+right[index]), crewNames.get(crewNames.size()-3+left[index])});
        }
    }

    public int getCrewSize() {
        return crewNames.size();
    }
    public String crewNameByNumber(int number) {
        return crewNames.get(number);
    }

    public boolean validateMatchable(String firstCrewName, String secondCrewName) {
        return Arrays.asList(alreadyMatched.get(firstCrewName)).contains(secondCrewName);
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
