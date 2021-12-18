package pairmatching.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CrewList {
    private List<String> backEndCrewList;
    private List<String> frontEndCrewList;

    public CrewList(List<String> backEndCrewList, List<String> frontEndCrewList) {
        this.backEndCrewList = backEndCrewList;
        this.frontEndCrewList = frontEndCrewList;
    }

    public void loadBackEndCrewList(String name) {
        try {
            File file = new File("C:\\Users\\sha11\\IdeaProjects\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");

            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            loadBackEndCrewList(name);
        }
    }

    public void loadFrontEndCrewList(String name) {
        try {
            File file = new File("C:\\Users\\sha11\\IdeaProjects\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md");

            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            loadFrontEndCrewList(name);
        }
    }

    public List<String> getBackEndCrewList() {
        return backEndCrewList;
    }

    public List<String> getFrontEndCrewList() {
        return frontEndCrewList;
    }

}
