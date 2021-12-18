package pairmatching;



import java.util.List;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Crews {
    ArrayList<String> backendCrewNames = new ArrayList<>();
    ArrayList<String> frontendCrewNames = new ArrayList<>();

    public void readBackend() {
        try{
            File backend = new File("C:\\Users\\woowahan\\Desktop\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");
            FileReader filereader = new FileReader(backend);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                backendCrewNames.add(line);
            }
            bufReader.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }

    public void readFrontend() {
        try{
            File frontend = new File("C:\\Users\\woowahan\\Desktop\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md");
            FileReader filereader = new FileReader(frontend);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                frontendCrewNames.add(line);
            }
            bufReader.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }


}
