package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BackendRepository {
    private List<String> backendCrews;
    
    public void addCrewNames() {
        try {
            backendCrews = Files.readAllLines(Paths.get("C:\\dev\fileSearch\\backend-crew.md"));
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
       
        
    }
    


}
