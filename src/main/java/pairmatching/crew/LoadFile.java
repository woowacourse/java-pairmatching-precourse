package pairmatching.crew;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LoadFile {
    List<String> backCrew = new ArrayList<>();
    List<String> frontCrew = new ArrayList<>();

    public void loadBackendCrew() {
        File file = new File("../../resources/backend-crew.md");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF8"));
            String str;
            while ((str = reader.readLine()) != null) {
                backCrew.add(str);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFrontendCrew() {
        File file = new File("../../resources/fronted-crew.md");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF8"));
            String str;
            while ((str = reader.readLine()) != null) {
                frontCrew.add(str);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getBackCrew() {
        loadBackendCrew();
        return CrewShuffle.getRandomCrews(backCrew);
    }

    public List<String> getFrontCrew() {
        loadFrontendCrew();
        return CrewShuffle.getRandomCrews(frontCrew);
    }
}
