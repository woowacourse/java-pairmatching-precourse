package pairmatching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewRepository;
import pairmatching.domain.LevelMisson;
import pairmatching.domain.LevelMissonRepository;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class Setup {
    public Setup() {
        setupMissons();
        setupCrews();
    }

    public void setupMissons() {
        LevelMissonRepository.addMission(new LevelMisson(Level.LEVEL1, Arrays.asList(
            new String[]{"자동차경주", "로또", "숫자야구게임"})));
        LevelMissonRepository.addMission(new LevelMisson(Level.LEVEL2, Arrays.asList(
            new String[]{"장바구니", "결제", "지하철노선도"})));
        LevelMissonRepository.addMission(new LevelMisson(Level.LEVEL3, Arrays.asList(
            new String[]{})));
        LevelMissonRepository.addMission(new LevelMisson(Level.LEVEL4, Arrays.asList(
            new String[]{"성능개선", "배포"})));
        LevelMissonRepository.addMission(new LevelMisson(Level.LEVEL5, Arrays.asList(
            new String[]{})));
    }

    public void setupCrews() {
        setupBackendCrews();
        setupFrontendCrews();
    }

    public void setupBackendCrews() {
        File file = getFile(Course.BACKEND);
        try{
            BufferedReader bufReader = getBufferedReader(file);
            String line = "";
            while((line = bufReader.readLine()) != null){
                Crew crew = new Crew(Course.BACKEND, line);
                CrewRepository.addBackendCrew(crew);
            }
            bufReader.close();
        } catch(IOException e){
            throw new IllegalArgumentException("[ERROR] 파일 입출력 오류가 발생했습니다.");
        }
    }

    public void setupFrontendCrews() {
        File file = getFile(Course.FRONTEND);
        try{
            BufferedReader bufReader = getBufferedReader(file);
            String line = "";
            while((line = bufReader.readLine()) != null){
                Crew crew = new Crew(Course.FRONTEND, line);
                CrewRepository.addFrontendCrew(crew);
            }
            bufReader.close();
        } catch(IOException e){
            throw new IllegalArgumentException("[ERROR] 파일 입출력 오류가 발생했습니다.");
        }
    }

    public File getFile(Course course) {
        URL resource = getClass().getClassLoader().getResource(course.getPath());
        try {
            File file = new File(resource.toURI());
            return file;
        }catch (URISyntaxException e) {
            throw new IllegalArgumentException("[ERROR] 파일을 찾을 수 없음");
        }
    }

    public BufferedReader getBufferedReader(File file) {
        try {
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            return new BufferedReader(filereader);
        }catch (FileNotFoundException e) {
            throw new IllegalArgumentException("[ERROR] 파일을 찾을 수 없음");
        }
    }

}
