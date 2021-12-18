package pairmatching.service;

import pairmatching.utils.Path;
import pairmatching.utils.ReadFile;
import java.util.List;

public class MatchingService {
    private String courseName;
    private String levelName;
    private String testName;
    private List<String> nameList;

    public MatchingService(String courseName, String levelName, String testName){
        this.courseName = courseName;
        this.levelName = levelName;
        this.testName = testName;
    }

//    파일을 읽어온다
    public void getFileName(){
        String path = getPath();
        this.nameList = ReadFile.readFile(path);
        return;
    }

    public String getPath(){
        if(courseName.equals("백엔드")) {
            return Path.BACKEND_PATH;
        }
        return Path.FRONTEND_PATH;
    }

    // 페어링을 한다
    public void getMatching(){
        return;
    }

    // 기존에 페어링이 있는 지 확인한다
    public void checkMatchingExist(){
        return;
    }

//    페어링이 제대로 되지 않았을 때 다시 페어링을 하는 기능
    public void matchAgain(){
        return;
    }

}
