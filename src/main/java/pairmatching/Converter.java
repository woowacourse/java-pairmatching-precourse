package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public List<Crew> convertFileToBackEndCrews() {
        List<Crew> crews = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/backend-crew.md"));
            String name;
            while ((name = reader.readLine()) != null) {
                crews.add(new Crew(Course.BACKEND, name));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return crews;
    }

    public List<Crew> convertFileToFrontEndCrews() {
        List<Crew> crews = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/frontend-crew.md"));
            String name;
            while ((name = reader.readLine()) != null) {
                crews.add(new Crew(Course.FRONTEND, name));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return crews;
    }
}
