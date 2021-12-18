package pairmatching.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputView {

    private static final String BE_CREWS_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FE_CREWS_FILE_PATH = "src/main/resources/frontend-crew.md";

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

    public static List<String> readBackEndCrews() throws IOException {
        return read(BE_CREWS_FILE_PATH);
    }

    public static List<String> readFrontEndCrews() throws IOException {
        return read(FE_CREWS_FILE_PATH);
    }
}

