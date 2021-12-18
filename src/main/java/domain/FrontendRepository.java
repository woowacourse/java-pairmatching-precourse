package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FrontendRepository {
    private List<String> frontendCrews;
    
    public void addCrewNames(){
        try {
            frontendCrews = Files.readAllLines(Paths.get("C:\\dev\fileSearch\\frontend-crew.md"));
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
         
    }
}
