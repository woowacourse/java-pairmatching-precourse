package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.utils.Random.*;
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
        String[] nameList = new String[] {
            "백호", "태웅", "치수", "태섭", "대만",
            "준호", "대협", "덕규", "태산", "경태",
            "수겸", "현준", "준섭", "한나", "소연",
            "호열", "대남", "용팔", "구식", "달재"
        };
        for (String name : nameList) {
            backendCrewList.add(new Crew(Course.BACKEND, name));
        }
    }

    private void generateFrontendList() {
        String[] nameList = new String[] {
            "보노", "시저", "쉐리", "신디", "다비",
            "덴버", "이브", "제시", "라라", "린다",
            "리사", "니콜", "로드", "윌터", "제키"
        };
        for (String name : nameList) {
            frontendCrewList.add(new Crew(Course.FRONTEND, name));
        }
    }

    // private void generateBackendList() {
    //     try {
    //         FileReader fileReader = new FileReader("backend-crew.md");
    //         BufferedReader bufferedReader = new BufferedReader(fileReader);
    //         String line = null;
    //         while ((line = bufferedReader.readLine()) != null) {
    //             backendCrewList.add(new Crew(Course.BACKEND, line));
    //         }
    //     } catch (IOException e) {
    //     }
    // }
    //
    // private void generateFrontendList() {
    //     System.out.println("front");
    //     try {
    //         FileReader fileReader = new FileReader("frontend-crew.md");
    //         System.out.println("front: " + fileReader);
    //         BufferedReader bufferedReader = new BufferedReader(fileReader);
    //         String line = null;
    //         while ((line = bufferedReader.readLine()) != null) {
    //             System.out.println(line);
    //             frontendCrewList.add(new Crew(Course.FRONTEND, line));
    //         }
    //     } catch (IOException e) {
    //     }
    // }
}
