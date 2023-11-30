package pairmatching.util;

import java.util.*;
import java.io.*;

public class FileIO {
    public  static List<String> backendCrewNamesFromFile(){
        return readFromFile("src/main/resources/backend-crew.md");
    }

    public  static List<String> frontendCrewNamesFromFile(){
        return readFromFile("src/main/resources/frontend-crew.md");
    }

    private static List<String> readFromFile(String filePath) {
        List<String> names = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
}

