package pairmatching;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

public class MatchingInfo {
    private List<List<String>> pairList=new ArrayList<>();

    public MatchingInfo(){}

    public boolean existInfo(){
        if(pairList.size()>0){
            return true;
        }
        return false;
    }
    
    public void match()

}
