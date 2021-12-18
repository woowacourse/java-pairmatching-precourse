package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewService {
    public List<String> readBackendCrews() throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/main/resources/backend-crew.md"));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            result.add(s);
        }
        return result;
    }

    public List<String> readFrontendCrews() throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/main/resources/frontend-crew.md"));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            result.add(s);
        }
        return result;
    }

    public boolean isUniqueCrews(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String target = list.get(i);
            List<String> tmpList = list;
            tmpList.remove(target);
            if (list.size() - 1 != tmpList.size()) {
                return false;
            }
        }
        return true;
    }
}
