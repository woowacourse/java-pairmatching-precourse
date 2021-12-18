package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FrontendRepository {
    private static List<String> frontendCrews;
    
    private static List<String> readAllLines​(Path path) throws IOException {
        frontendCrews = Files.readAllLines(Paths.get("C:\\dev\fileSearch\\frontend-crew.md")); 
        return frontendCrews;
    }
}
