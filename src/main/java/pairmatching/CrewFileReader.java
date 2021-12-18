package pairmatching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

public class CrewFileReader {
    private static final String FILE_PATH="src/main/resources/";
    private static final String BACKEND_FILE = "backend-crew.md";
    private static final String FRONTEND_FILE = "frontend-crew.md";

    public CrewFileReader() {
    }

    public static List<String> getCrew(boolean isBackend) {
        System.out.println("getCrew Start");
        List<String> crewList = new ArrayList<>();

        try {
            File file = new File(getFilePath(isBackend));
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                crewList.add(line);
            }
        } catch (Exception e) {}
        System.out.println("getCrew Return");
        return crewList;
    }

    private static String getFilePath(boolean isBackend){
        if(isBackend){
            return FILE_PATH+BACKEND_FILE;
        }
        return FILE_PATH+FRONTEND_FILE;
    }
}
