package pairmatching.view.input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrewNameFileInput implements CrewNameInput {
    public List<String> readNames(final String path) throws IOException {
        List<String> names = new ArrayList<>();
        File file = new File(path);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (Exception exception) {
            throw new FileNotFoundException("파일을 찾을 수 없습니다.");
        }
        addNames(reader, names);
        return names;
    }

    private void addNames(final BufferedReader bufferedReader, final List<String> names) throws IOException {
        while (true) {
            String name = bufferedReader.readLine();
            if (name == null) {
                break;
            }
            names.add(name);
        }
    }
}
