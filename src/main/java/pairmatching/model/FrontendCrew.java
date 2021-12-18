package pairmatching.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FrontendCrew {
    private static List<Crew> frontendCrewList;

    public static List<Crew> getFrontendCrewList() {
        return frontendCrewList;
    }

    public static void createFrontendCrewList(){
        frontendCrewList = new ArrayList<>();
        try{
            File file = new File("src/main/resources/backend-crew.md");
            BufferedReader inFile = new BufferedReader(new FileReader(file));
            String person = null;
            while((person = inFile.readLine())!= null){
                Crew crew = new Crew("백엔드", person);
                frontendCrewList.add(crew);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
