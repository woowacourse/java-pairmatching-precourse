package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BackendRepository {
    private static List<String> backendCrews;
    
    private static List<String> readAllLines​(Path path) throws IOException {
        backendCrews = Files.readAllLines(Paths.get("C:\\dev\fileSearch\\backend-crew.md")); 
        return backendCrews;
    }
    


}
