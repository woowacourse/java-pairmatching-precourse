package pairmatching.source;

import java.util.List;

public class Pair {
    private static final String NAME_DELIMITER = " : ";

    private List<Crew> crewList;

    public Pair(List<Crew> crewList){
        this.crewList = crewList;
    }

    @Override
    public String toString(){
        StringBuilder crewsName = new StringBuilder("");

        for(int i=0 ; i<crewList.size() ; ++i ){
            crewsName.append(crewList.get(i).getName());

            if(i != crewList.size() -1 ){
                crewsName.append(NAME_DELIMITER);
            }

        }

        return crewsName.toString();
    }
}
