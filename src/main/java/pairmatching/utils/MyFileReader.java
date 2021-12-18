package pairmatching.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    public static List<String> readBackendCrewFile() {
        List<String> backendCrewList = new ArrayList<>();
        File file = new File("src/main/resources/backend-crew.md");
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null) {
                backendCrewList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return backendCrewList;
    }

    public static List<String> readFrontendCrewFile() {
        List<String> frontendCrewList = new ArrayList<>();
        File file = new File("src/main/resources/frontend-crew.md");
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null) {
                frontendCrewList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return frontendCrewList;
    }
}
