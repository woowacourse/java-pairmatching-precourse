package pairmatching.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BackendCrew {
    private static List<Crew> backendCrewList;

    public static List<Crew> getBackendCrewList() {
        return backendCrewList;
    }

    public static void createBackendCrewList(){
        backendCrewList = new ArrayList<>();
        try{
            File file = new File("src/main/resources/backend-crew.md");
            BufferedReader inFile = new BufferedReader(new FileReader(file));
            String person = null;
            while((person = inFile.readLine())!= null){
                Crew crew = new Crew("백엔드", person);
                backendCrewList.add(crew);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
