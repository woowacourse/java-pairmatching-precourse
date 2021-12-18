package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CrewService {
    public ArrayList<String> readBackendCrews() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/main/resources/backend-crew.md"));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            result.add(s);
        }
        return result;
    }

    public ArrayList<String> readFrontendCrews() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/main/resources/frontend-crew.md"));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            result.add(s);
        }
        return result;
    }

    public boolean isUniqueCrews(ArrayList<String> backend, ArrayList<String> frontend) {
        for (String s : backend) {
            if (frontend.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
