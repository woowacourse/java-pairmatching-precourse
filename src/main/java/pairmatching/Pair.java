package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<Crew> crewsOfPair;

    public Pair(List<Crew> pairs) {
        this.crewsOfPair = pairs;
    }

    public List<Crew> getCrewsOfPair() {
        return crewsOfPair;
    }

    public List<String> searchNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Crew crew : crewsOfPair){
            names.add(crew.getName());
        }
        return names;
    }

    public void merge(Crew crew){
        crewsOfPair.add(crew);
    }
}
