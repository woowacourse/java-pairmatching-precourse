package pairmatching;


import static pairmatching.Type.*;

import java.util.List;

public class Application {
    static Pair pair = new Pair();
    public static void main(String[] args) {
        pairMatching(BACKEND);
        pairMatching(FRONTEND);
    }

    static void pairMatching(Type type){
        String fileName = "";
        if(type.equals(BACKEND)){
            fileName = "backend";
        }else if(type.equals(FRONTEND)){
            fileName = "frontend";
        }
        List<String> backendList = CrewInfoReader.readCrewListByType(fileName+"-crew");
        Crew crewList = new Crew(type, backendList);
        // crewList.getCrewByType(type);

        List<String> shuffle = crewList.shuffleCrewList(type);
        // for(String name : shuffle){
        //     System.out.print(name+" ");
        // }
        randomMatching(shuffle);

        pair.printPair();

    }

    static void randomMatching(List<String> list){
        int size = list.size();
        int idx = 0;
        while(size > idx){
            if((size-idx)/2==1 && (size-idx)%2 == 1){
                pair.getPair(list.get(idx),list.get(idx+1), list.get(idx+2));
                idx+= 3;
            }else{
                pair.getPair(list.get(idx),list.get(idx+1));
                idx += 2;
            }
        }
    }
}
