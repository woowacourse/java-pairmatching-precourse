package pairmatching.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputView {

    public static List<String> read(final String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        List<String> inputCrewLineList = new ArrayList<String>();
        while (true) {
            String line = bufferedReader.readLine();
            inputCrewLineList.add(line);
            if (line == null) {
                break;
            }
        }
        bufferedReader.close();
        return inputCrewLineList;
    }
}

