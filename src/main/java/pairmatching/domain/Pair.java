package pairmatching.domain;

import pairmatching.util.InvalidPairException;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private static final String PAIR_FORMAT_TWO = "%s : %s\n";
    private static final String PAIR_FORMAT_THREE = "%s : %s : %s\n";
    private static final String INVALID_PAIR_ERROR = "[ERROR] 유효하지 않은 페어입니다.";


    private final Course course;
    private final Level level;
    private final Mission mission;
    private final Crews crews;
    private final List<List<String>> pair;

    public Pair(SearchingInfoDto searchingInfoDto, Crews crews, List<List<String>> candidatePair){
        this.course = searchingInfoDto.getCourse();
        this.level = searchingInfoDto.getLevel();
        this.mission = searchingInfoDto.getMission();
        this.crews = crews;
        validatePair(candidatePair);
        pair = candidatePair;
        savePairInformation(pair);
    }

    private void validatePair(List<List<String>> candidatePair){
        if(isDuplicatedPair(candidatePair)){
            throw new InvalidPairException(INVALID_PAIR_ERROR);
        }
    }

    private boolean isDuplicatedPair(List<List<String>> pair){
        for(List<String> crewNames : pair){
            if(isAlreadyPaired(new ArrayList<>(crewNames))){
                return true;
            }
        }
        return false;
    }

    private boolean isAlreadyPaired(List<String> crewNames){
        while(crewNames.size()>0){
            Crew crew = crews.findCrew(course, crewNames.remove(0));
            if(isAlreadyPairedWithOthers(crew, crewNames)){
                return true;
            }
        }
        return false;
    }

    private boolean isAlreadyPairedWithOthers(Crew crew, List<String> crewNames){
        for(String name : crewNames){
            if(crew.hasPairedAtLeastOnceInLevel(level, name)){
                return true;
            }
        }
        return false;
    }

    private void savePairInformation(List<List<String>> pair){
        for(List<String> crewNames : pair){
            saveOnePairInformation(crewNames);
        }
    }

    private void saveOnePairInformation(List<String> crewNames){
        for(int crewIndex = 0; crewIndex<crewNames.size(); crewIndex++){
            Crew crew = crews.findCrew(course, crewNames.get(crewIndex));
            saveOnePairInformationToCrew(crew, crewNames, crewIndex);
        }
    }

    private void saveOnePairInformationToCrew(Crew crew, List<String> crewNames, int crewIndex){
        for(int index = 0; index<crewNames.size(); index++){
            if(index == crewIndex) {
                continue;
            }
            crew.addPairName(level, crewNames.get(index));
        }

    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    public String toPrintable(){
        StringBuilder builder = new StringBuilder();
        for(List<String> names : pair){
            if(names.size()==3){
                builder.append(String.format(PAIR_FORMAT_THREE, names.get(0), names.get(1), names.get(2)));
                break;
            }
            builder.append(String.format(PAIR_FORMAT_TWO, names.get(0), names.get(1)));
        }
        return builder.toString();
    }
}
