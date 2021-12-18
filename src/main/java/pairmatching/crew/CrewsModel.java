package pairmatching.crew;

import pairmatching.course.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.course.Course.*;

// 인원 파일로 읽어와서 다 보여주기.

public class CrewsModel {
    private Crews crews;
    private BufferedReader reader;
    private Crew crew;
    private String path = CrewsModel.class.getResource("").getPath();
    public CrewsModel() {
        this.crews = new Crews();
    }

    public List<Crew> readBackEndCrew() throws IOException {
        List<Crew> crewList = new ArrayList<>();
        reader = new BufferedReader(
                new FileReader("C:\\Users\\chamg\\OneDrive\\바탕 화면\\wootaco_finalTest\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md")
        );
        String str;
        while((str = reader.readLine()) != null) {
            this.crew = new Crew(BACKEND, str);
            crewList.add(crew);
        }
        reader.close();
        crews.setBackEndCrews(crewList);
        return crewList;
    }

    public List<Crew> readFrontEndCrew() throws IOException{
        List<Crew> crewList = new ArrayList<>();
        reader = new BufferedReader(
                new FileReader("C:\\Users\\chamg\\OneDrive\\바탕 화면\\wootaco_finalTest\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md")
        );
        String str;
        while((str = reader.readLine()) != null) {
            this.crew = new Crew(FRONTEND, str);
            crewList.add(crew);
        }
        reader.close();
        crews.setFrontEndCrews(crewList);
        return crewList;
    }

    public Crews getCrews() {
        return crews;
    }
}
