package pairmatching.source;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mission {
    private final String name;
    private boolean isMatched = false;
    private List<Pair> missionPairs = new ArrayList<>();

    public Mission(String name){
        this.name = name;
    }

    public void matchingPair(List<String> crewNames, HashMap<String, Crew> crewMap ){
        List<String> shuffledNames = Randoms.shuffle(crewNames);

        if(shuffledNames.size() % 2 == 0){
            matchEvenPair(shuffledNames,crewMap);
            return;
        }

        matchOddPair(shuffledNames,crewMap);
        isMatched = true;
    }

    private void matchOddPair(List<String> shuffledNames, HashMap<String, Crew> crewMap){
        List<Crew> pairCrews  = new ArrayList<>();

        for(int i=0; i< shuffledNames.size() -1 ; i+=2){
            pairCrews = new ArrayList<>();
            pairCrews.add(crewMap.get(shuffledNames.get(i)));
            pairCrews.add(crewMap.get(shuffledNames.get(i+1)));
            if(i < shuffledNames.size() -3){
                missionPairs.add(new Pair(pairCrews));
            }
        }

        pairCrews.add(crewMap.get(shuffledNames.get(shuffledNames.size() -1))); // 마지막 크루 삽입
        missionPairs.add(new Pair(pairCrews));
    }

    private void matchEvenPair(List<String> shuffledNames, HashMap<String, Crew> crewMap){
        List<Crew> pairCrews;

        for(int i=0; i< shuffledNames.size(); i+=2){
            pairCrews = new ArrayList<>();
            pairCrews.add(crewMap.get(shuffledNames.get(i)));
            pairCrews.add(crewMap.get(shuffledNames.get(i+1)));
            missionPairs.add(new Pair(pairCrews));
        }

    }

    public boolean getIsMatched(){
        return isMatched;
    }

    public String getName(){
        return this.name;
    }

    public void printMatchedPairs(){

        for(Pair currentPair : missionPairs){
            System.out.println(currentPair);
        }
    }
}
