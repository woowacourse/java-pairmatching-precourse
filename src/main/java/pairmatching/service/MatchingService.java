package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Pair;
import pairmatching.utils.Path;
import pairmatching.utils.ReadFile;

import java.util.ArrayList;
import java.util.List;

public class MatchingService {
    private String courseName;
    private String levelName;
    private String testName;
    private List<String> nameList;
    private boolean isOdd;
    private List<String> shuffleNameList = new ArrayList<String>();
    private List<Pair> shufflePairList = new ArrayList<Pair>();

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
        getFileName();
        List<String> shuffledCrew = Randoms.shuffle(this.nameList); // 섞인 크루 이름 목록
        this.shuffleNameList = shuffledCrew;
        cutList();
        return;
    }

    public void cutList(){
        isOdd();
        if(this.isOdd){
            cutOdd();
            return;
        }
        cutEven();
        return;
    }

    public void cutOdd(){
        for(int i=0; i<this.shuffleNameList.size()-1; i++){
            Pair pair = new Pair(this.shuffleNameList.get(i), this.shuffleNameList.get(i + 1));
            this.shufflePairList.add(pair);

            if(i==this.shuffleNameList.size()-2){
                pair.addExtra(this.shuffleNameList.get(i+2));
            }
        }
        return;
    }

    public void cutEven(){
        for(int i=0; i<this.shuffleNameList.size()-1; i++){
            Pair pair = new Pair(this.shuffleNameList.get(i), this.shuffleNameList.get(i + 1));
            this.shufflePairList.add(pair);
        }
        return;
    }

    public void isOdd(){
        int crewNum = this.nameList.size();
        if(crewNum%2==1){
            this.isOdd=true;
            return;
        }
        this.isOdd=false;
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
