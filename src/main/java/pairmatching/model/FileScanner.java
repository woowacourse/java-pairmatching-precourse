package pairmatching.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileScanner {

    public List<String> backendCrewFileScanner() {
        List<String> crewNames = new ArrayList<>();
        try {
            File file = new File("src/main/resources/backend-crew.md");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                crewNames.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        }
        return crewNames;
    }

    public List<String> frontendCrewFileScanner() {
        List<String> crewNames = new ArrayList<>();
        try {
            File file = new File("src/main/resources/frontend-crew.md");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                crewNames.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        }
        return crewNames;
    }
}
