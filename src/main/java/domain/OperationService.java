package domain;

import java.util.List;
import java.util.Set;

public class OperationService {
    private static final String ERROR_MESSAGE = "[ERROR] 매칭이 가능하지 않습니다.";

    public static void runPairmatching(Course course, Mission mission) {
        List<String> list;
        if(course.equals(Course.BACKEND)) {
            list = BackendRepository.shuffleCrew();
            if(!mission.getBackendCrew().isEmpty()) {
                renewBackendPair(list,mission);
                return;
            }
            mission.renewBackendList(list);
        }
        if(course.equals(Course.FRONTEND)) {
            list = FrontendRepository.shuffleCrew();
            if(!mission.getFrontendCrew().isEmpty()) {
                renewFrontendPair(list, mission);
                return;
            }
            mission.renewFrontendList(list);
        }
    }
    
    private static void renewBackendPair(List<String> newList, Mission mission) {
        List<String> currentList = mission.getBackendCrew();
        int index = 0;
        while(index<=3) {
            if(checkBackendPair(currentList, newList)) {
                mission.renewBackendList(newList);
                break;
            }
            
            index++;
        }
        if(index>3) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
    
    private static void renewFrontendPair(List<String> newList, Mission mission) {
        List<String> currentList = mission.getFrontendCrew();
        int index = 0;
        while(index<=3) {
            if(checkFrontendPair(currentList, newList)) {
                mission.renewFrontendList(newList);
                break;
            }
            
            index++;
        }
        if(index>3) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
        
     private static boolean checkBackendPair(List<String> currentList, List<String> newList) {
         Set<String> currentPairs = BackendRepository.generatePairs(currentList);
         Set<String> newPairs = BackendRepository.generatePairs(newList);
         int size = currentPairs.size()+newPairs.size();
         
         for(String s : newPairs) {
             currentPairs.add(s);
         }
         
         if(currentPairs.size() < size) {
             return false;
         }
         return true;
     }
     
     private static boolean checkFrontendPair(List<String> currentList, List<String> newList) {
         Set<String> currentPairs = FrontendRepository.generatePairs(currentList);
         Set<String> newPairs = FrontendRepository.generatePairs(newList);
         int size = currentPairs.size()+newPairs.size();
         
         for(String s : newPairs) {
             currentPairs.add(s);
         }
         
         if(currentPairs.size() < size) {
             return false;
         }
         return true;
     }
}
