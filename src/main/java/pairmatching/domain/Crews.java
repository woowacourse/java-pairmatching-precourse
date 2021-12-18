package pairmatching.domain;

import static pairmatching.utils.Random.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {

    private List<Crew> backendCrewList;
    private List<Crew> frontendCrewList;

    public Crews() {
        backendCrewList = new LinkedList<>();
        frontendCrewList = new LinkedList<>();
        initialize();
    }

    public void initialize() {
        generateBackendList();
        generateFrontendList();
    }

    public List<String> matching(String course) {
        if (course.equals("백엔드")) {
            return generateRandomMatching(getNames(backendCrewList));
        }
        return generateRandomMatching(getNames(frontendCrewList));
    }

    private List<String> getNames(List<Crew> list) {
        return list.stream()
            .map(Crew::getName)
            .collect(Collectors.toList());
    }

    private void generateBackendList() {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            FileInputStream fileInputStream = new FileInputStream(loader.getResource("backend-crew.md").getFile());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                backendCrewList.add(new Crew(Course.BACKEND, line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateFrontendList() {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            FileInputStream fileInputStream = new FileInputStream(loader.getResource("frontend-crew.md").getFile());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                frontendCrewList.add(new Crew(Course.FRONTEND, line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
