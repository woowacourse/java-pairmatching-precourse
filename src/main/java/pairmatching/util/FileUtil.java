package pairmatching.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {
    public static List<String> readFileAsList(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
