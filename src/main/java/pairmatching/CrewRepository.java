package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private List<String> backend = new ArrayList<>();
    private List<String> frontend = new ArrayList<>();

    public void initBackend(String path) {
        addCrewsByFile(path, backend);
    }

    public void initFrontend(String path) {
        addCrewsByFile(path, frontend);
    }

    public void addCrewsByFile(String path, List<String> repository) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                repository.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> findByCourse(Course course) {
        if (course == Course.FRONTEND) {
            return new ArrayList<>(frontend);
        }
        if (course == Course.BACKEND) {
            return new ArrayList<>(backend);
        }
        return null;
    }
}
